package br.com.fiap.tds.cp2.model;

public class Conta {
	//Atributos
	private String agencia, conta;
	private double saldo;
	private double[] transacoes = new double[10];
	private int ponteiroArray;
	private boolean contaBloqueio;
	//Construtor
	public Conta(String agencia, String conta, double saldo) {
		super();
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
	}
	
	//Getters
	public double getTransacoes(int i) {
		return transacoes[i];
	}
	
	public String getAgencia() {
		return agencia;
	}
	public String getConta() {
		return conta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public int getPonteiroArray() {
		return ponteiroArray;
	}

	public boolean isContaBloqueio() {
		return contaBloqueio;
	}
	//Setters
	public void setTransacoes(double transacoes) {
		if(ponteiroArray < 10) {
			this.transacoes[ponteiroArray] = transacoes;
			ponteiroArray++;
		} else {
			ponteiroArray = 0;
			this.transacoes[ponteiroArray] = transacoes;
		}
	}
		
	public void setContaBloqueio(boolean contaBloqueio) {
		this.contaBloqueio = contaBloqueio;
	}
	
	//Métodos
	public void alteraSaldo(double saldo) {
		if(saldo > 0) {
			this.saldo += saldo;
		} else {
			this.saldo += saldo;
		}
	}//alteraSaldo
	
	public void imprimeTransacoes() {
		System.out.println("Relatório Transações: ");
		for(int i = 0; i < ponteiroArray; i++) {
			System.out.println("Valor: R$" + transacoes[i]);
		}
	}//imprimeTransacoes
	
	

}//class