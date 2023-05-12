package br.com.fiap.tds.cp2.model;

public class Administrador extends Pessoa{
	//Atributos
	private Usuario usuario;
	private String idAdm;
	
	//Construtor
	
	public Administrador(String nome, String cpf, String login, String senha, Usuario usuario, String idAdm) {
		super(nome, cpf, login, senha);
		this.usuario = usuario;
		this.idAdm = idAdm;
	}
	
	//Getter
	public Usuario getUsuario() {
		return usuario;
	}
	public String getIdAdm() {
		return idAdm;
	}
	//Setter
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setIdAdm(String idAdm) {
		this.idAdm = idAdm;
	}
	
	//Métodos
	public void bloqueiaConta() {
		System.out.println("Para bloquear a conta do cliente, favor, informar seu ID:");
		String idInformado = leitor.next();
		if(this.loginEfetuado == true && idInformado.equals(this.idAdm)) {
			usuario.getConta().setContaBloqueio(true);
			System.out.println("Conta bloqueada com sucesso!");
		} else {
			System.out.println("Verifique se está logado ou ID está correto.");
		}
	}//bloqueioConta
	public void transacoesSuspeitas() {
		double suspeito = 1000.00;
		if(this.loginEfetuado == true) {
			System.out.println("Serão consideradas suspeitas as transações acima de R$: " + suspeito);
			System.out.println("Segue a lista das movimentações do cliente para serem analisadas abaixo:");
			usuario.getConta().imprimeTransacoes();
		} else {
			System.out.println("Efetue o login!");
		}
	}//transacoesSuspeitas
	
}//class
