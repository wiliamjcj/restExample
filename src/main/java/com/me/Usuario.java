package com.me;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Integer id;

	public Usuario() {
	}

	public Usuario(String nome, String email, String senha, Integer id) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
