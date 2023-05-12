package br.com.fiap.tds.cp2.model;

public class AssessorFinanceiro extends Pessoa{
	//Atributos
	private Usuario usuario;
	
	//Construtor
	public AssessorFinanceiro(String nome, String cpf, String login, String senha, Usuario usuario) {
		super(nome, cpf, login, senha);
		this.usuario = usuario;
	}
	//Getter
	public Usuario getUsuario() {
		return usuario;
	}
	//Setter
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//Métodos
	public void calculaImposto() {
		if(this.loginEfetuado == true) {
			double impostoCalculado = usuario.getConta().getSaldo() * 0.06;
			System.out.println("Com base no seu saldo em conta, o imposto seria de : R$" + impostoCalculado);
		} else {
			System.out.println("Favor, efetuar o login!");
		}
	}//calculaImposto
	public void planejaInvestimento() {
		System.out.println("Pensando em um longo prazo e na sua saúde financeira, não seria bom investir todo o seu dinheiro em uma aplicação só. Como Assessor Financeiro, um planejamento que posso te passar seria:");
		System.out.println("40% - do seu saldo em uma aplicação personalizada comigo de longo prazo, onde seu dinheiro ficaria retido por 5 anos, porém, rendendo a uma taxa de 8% a.m.");
		System.out.println("30% - do seu saldo em uma aplicação comum de médio prazo, onde seu dinheiro ficaria retido por 1 ano e rendendo 4% a.m.");
		System.out.println("15% - do seu saldo em uma aplicação comum de curto prazo, onde seu dinheiro ficaria retido somente 1 mês rendendo à 2% a.m.");
		System.out.println("Já o restante do seu saldo, seria interessante deixar em conta mesmo rendendo para o caso de emergências em que você precise de dinheiro disponível para uso");
	}//planejaInvestimento
	public void analisaRisco() {
		System.out.println("Dos 3 tipos de investimento que temos disponíveis, o investimento personalizado comigo seria o que tem menos risco.");
		System.out.println("Já o investimento de 1 ano rendendo 4% a.m. tem um risco mais elevado, porém, ainda assim baixo");
		System.out.println("Quanto ao investimento de 1 mês rendendo 2% a.m. tem um risco moderado");
	}//analisaRisco
	public void investePersonalizado() {
		if(this.loginEfetuado == true && usuario.getConta().isContaBloqueio() != true) {
			System.out.println("Com esse investimento, seu dinheiro ficara retido por 5 anos rendendo 8% a.m.! ");
			System.out.println("Informe o valor a ser investido: ");
			double montanteInicial = leitor.nextDouble();
			double lucro = 0;
			double montanteFinal = montanteInicial;
			if(usuario.getConta().getSaldo() >= montanteInicial) {
				for(int i = 1; i <= 60; i++) {
					montanteFinal *= 1.08;
				}
				lucro = montanteFinal - montanteInicial;
				System.out.println("Lucro: R$" + lucro);
				usuario.getConta().alteraSaldo(lucro);
			} else {
				System.out.println("Saldo insuficiente!");
			}
		} else {
			System.out.println("Favor efetuar o login e verificar se a conta do cliente está bloqueada");
		}
	}//investePersonalizado
}
