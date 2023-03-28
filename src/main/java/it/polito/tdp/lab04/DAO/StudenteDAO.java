package it.polito.tdp.lab04.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	
	public Studente getStudente(int matricola) {
		
		String sql = "SELECT * "
				+ "FROM studente "
				+ "WHERE matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			Studente s = null;
			
			while(rs.next()) {	
				
				s = new Studente(rs.getInt("matricola"), rs.getString("cognome"), 
						rs.getString("nome"), rs.getString("CDS"));
				
			}
				
		rs.close();
		st.close();
		conn.close();
		
		return s;
		
	} catch (SQLException e) {
		System.out.println("Error in StudenteDAO");
		e.printStackTrace();
		return null;
		}
	}
	
	
	public List<Corso> getCorsiByMatricola(int matricola) {
		
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM studente s, iscrizione i, corso c "
				+ "WHERE s.matricola = i.matricola and i.codins = c.codins and s.matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			List<Corso> result = new ArrayList<Corso>();
			
			while(rs.next()) {
				
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				result.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));
				
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			
			System.out.println("ERRORE in getCorsiByMatricola(int matricola)");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
