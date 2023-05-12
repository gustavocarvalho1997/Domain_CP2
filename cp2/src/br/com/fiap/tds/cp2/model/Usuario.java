package br.com.fiap.tds.cp2.model;


public class Usuario extends Pessoa{
	//Atributos
	private Conta conta;
	//Construtores
	public Usuario(String nome, String cpf, String login, String senha, Conta conta) {
		super(nome, cpf, login, senha);
		this.conta = conta;
	}
	//Getters
	public Conta getConta() {
		return conta;
	}
	//Métodos
	public String retornarInformacoesConta() {
		return "Agencia: " + conta.getAgencia() + ", Conta: " + conta.getConta() 
		+ ", Saldo: R$" + conta.getSaldo();
	}//retornarInformacoesConta	
	@Override
	public void logar() {
		System.out.println("Favor, informe seu login: ");
		String loginInformado = leitor.next();
		System.out.println("Favor, informe sua senha: ");
		String senhaInformada = leitor.next();
		if(loginInformado.equals(login) && senhaInformada.equals(senha)) {
			this.loginEfetuado = true;
			System.out.println("Seja bem vindo(a) " + nome + "!");
			System.out.println(retornarInformacoesConta());
		} else {
			System.out.println("Login não autorizado, confira as informações digitadas!");
		}
	}//logar
	public void transfereDinheiro() {
		if(this.loginEfetuado == true && conta.isContaBloqueio() != true) {
			System.out.println("Insira a agencia do destinatário: ");
			String agenciaInformada = leitor.next();
			System.out.println("Insira a conta do destinatário: ");
			String contaInformada = leitor.next();
			System.out.println("Insira o valor da transferência: ");
			double valorTransferido = leitor.nextDouble(); 
			if(conta.getSaldo() >= valorTransferido) {
				valorTransferido *= -1;
				conta.setTransacoes(valorTransferido);
				conta.alteraSaldo(valorTransferido);
				System.out.println("Transferência efetuada com sucesso para a agencia: " 
						+ agenciaInformada + ", conta: " + contaInformada + ".");
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			System.out.println("Favor, verifica se está logado ou se sua conta está bloqueada!");
		}	
	}//transfereDinheiro
	public void pagarBoleto() {
		if(this.loginEfetuado == true && conta.isContaBloqueio() != true) {
			System.out.println("Insira o código do boleto: ");
			String boletoInformado = leitor.next();
			System.out.println("Insira o valor da pagar: ");
			double valorPago = leitor.nextDouble(); 
			if(conta.getSaldo() >= valorPago) {
				valorPago *= -1;
				conta.setTransacoes(valorPago);
				conta.alteraSaldo(valorPago);
				System.out.println("Pagamento efetuado com sucesso referente ao boleto: " 
						+ boletoInformado + "!");
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			System.out.println("Favor, verifica se está logado ou se sua conta está bloqueada!");
		}
	}//pagarBoleto
	public void investir() {
		if(this.loginEfetuado == true && conta.isContaBloqueio() != true) {
			System.out.println("Escolha seu investimento: ");
			System.out.println("1 - Para investir durante 1 mês à 2% a.m");
			System.out.println("2 - Para investir durante 1 ano à 4% a.m");
			int opcao = leitor.nextInt();
			System.out.println("Informe o valor a ser investido: ");
			double montanteInicial = leitor.nextDouble();
			double lucro = 0;
			double montanteFinal = montanteInicial;
			if(conta.getSaldo() >= montanteInicial) {
				if(opcao == 1) {
					montanteFinal *= 1.02;
					lucro = montanteFinal - montanteInicial;
					System.out.println("Lucro: R$" + lucro);
					conta.alteraSaldo(lucro);
				} else if (opcao == 2) {
					for(int i = 1; i <= 12; i++) {
						montanteFinal *= 1.04;
					}
					lucro = montanteFinal - montanteInicial;
					System.out.println("Lucro: R$" + lucro);
					conta.alteraSaldo(lucro);
				} else {
					System.out.println("Opção desconhecida");
				}
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			System.out.println("Favor, verifica se está logado ou se sua conta está bloqueada!");
		}
	}//investir
}//Class