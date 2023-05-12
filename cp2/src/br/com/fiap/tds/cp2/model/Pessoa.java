package br.com.fiap.tds.cp2.model;

import java.util.Scanner;

public class Pessoa {
	Scanner leitor = new Scanner(System.in);
	//Atributos
	protected String nome, cpf, login, senha;
	protected boolean loginEfetuado;
	//Construtor
	public Pessoa(String nome, String cpf, String login, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}

	//Getters
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public boolean isLoginEfetuado() {
		return loginEfetuado;
	}
	
	
	//Método
	public void logar() {
		System.out.println("Favor, informe seu login: ");
		String loginInformado = leitor.next();
		System.out.println("Favor, informe sua senha: ");
		String senhaInformada = leitor.next();
		
		if(loginInformado.equals(login) && senhaInformada.equals(senha)) {
		this.loginEfetuado = true;
		System.out.println("Seja bem vindo(a) " + nome + "!");
		} else {
		System.out.println("Login não autorizado, confira as informações digitadas!");
		}
	}
	
	
	
}//class