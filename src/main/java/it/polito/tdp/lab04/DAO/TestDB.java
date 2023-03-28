package it.polito.tdp.lab04.DAO;

import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		List<Corso> lista = cdao.getTuttiICorsi();
		
		for(Corso c : lista) {
			
			System.out.println(c);
			
		}
		
		StudenteDAO sdao = new StudenteDAO();
		
		Studente s = sdao.getStudente(200482);
		
		System.out.println(s);
	}

}
