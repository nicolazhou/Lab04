package it.polito.tdp.lab04.model;

import java.util.Objects;

public class Studente {

	private int matricola;
	private String cognome;
	private String nome;
	private String CDS;
	
	
	public Studente(int matricola, String cognome, String nome, String CDS) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.CDS = CDS;
	}


	public int getMatricola() {
		return matricola;
	}


	public String getCognome() {
		return cognome;
	}


	public String getNome() {
		return nome;
	}


	public String getCDS() {
		return CDS;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(matricola);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return matricola == other.matricola;
	}


	@Override
	public String toString() {
		return this.matricola + " , " + this.nome + " , " + this.cognome + " , " + this.CDS;
	}
	
	
}
