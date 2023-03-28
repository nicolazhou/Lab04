package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

import java.util.*;

public class Model {

	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	
	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}
	
	
	public List<Corso> getAllCorsi() {
		return this.corsoDAO.getTuttiICorsi();
	}
	
	
	public List<Studente> getAllStudentiCorso(Corso corso) {
		return this.corsoDAO.getStudentiIscrittiAlCorso(corso);
	}
	
	
	public Studente getStudente(int matricola) {
		return studenteDAO.getStudente(matricola);
	}
	
	
	public List<Corso> getCorsiByStudente(int matricola) {
		return this.studenteDAO.getCorsiByMatricola(matricola);
	}
	
	
	public boolean isIscritto(Studente studente, Corso corso) {
		return this.corsoDAO.iscriviStudenteACorso(studente, corso);
	}
	
	
}
