package it.polito.tdp.lab04.model;

public class Corso {
	
	private String codins;
	private int crediti;
	private String nome;
	private int periodo;
	
	
	public Corso(String codins, int crediti, String nome, int periodo) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;
	}
	
	
	public String getCodins() {
		return codins;
	}
	
	public void setCodins(String codins) {
		this.codins = codins;
	}
	
	public int getCrediti() {
		return crediti;
	}
	
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}


	@Override
	public String toString() {
		return this.nome; //this.codins + " " + this.crediti + " " + this.nome + " " + this.periodo;
	}
	

}
