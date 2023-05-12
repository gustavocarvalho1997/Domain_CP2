package br.com.fiap.tds.cp2.terminal;

import br.com.fiap.tds.cp2.model.Administrador;
import br.com.fiap.tds.cp2.model.AssessorFinanceiro;
import br.com.fiap.tds.cp2.model.Conta;
import br.com.fiap.tds.cp2.model.Usuario;

public class Terminal {
	public static void main(String[] args) {
		Conta conta = new Conta("1896", "50600-4", 7000.00);
		Usuario usuario = new Usuario("Gustavo", "151818115-58", "login123", "senha123", conta);
		AssessorFinanceiro assessor = new AssessorFinanceiro("Ronald", "125487158-88", "login456", "senha456", usuario);
		Administrador administrador = new Administrador("Vitor", "487598478-55", "login789", "senha789", usuario, "rm123456");
		
		//login: login123 senha:senha123
		usuario.logar();
		
		
		usuario.transfereDinheiro();
		//Exemplo boleto: 00190.50095.40144.816069.0689.350314.3.37370000000100
		usuario.pagarBoleto();
		
		usuario.investir();
		
		usuario.getConta().imprimeTransacoes();
		System.out.println("Saldo atual: R$" + usuario.getConta().getSaldo());
		
		//login: login456 senha: senha456
		assessor.logar();
		
		assessor.calculaImposto();
		assessor.planejaInvestimento();
		assessor.investePersonalizado();
		
		//login: login789 senha: senha789
		administrador.logar();
		
		
		administrador.transacoesSuspeitas();
		//id: rm123456
		administrador.bloqueiaConta();
		
		usuario.transfereDinheiro();
		
		
		

		
		
	}//MAIN
}//CLASS
