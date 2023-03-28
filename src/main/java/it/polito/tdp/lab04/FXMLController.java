package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class FXMLController {

	private Model model;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnTick;

    @FXML
    private ComboBox<Corso> cmbCorsi;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCercaCorsi(ActionEvent event) {

    	txtResult.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	String input = txtMatricola.getText();
    	
    	int matricola = 0;
    	
    	try {
    		
    		matricola = Integer.parseInt(input);
    		
    	} catch(NumberFormatException e) {
    		
    		txtResult.setText("Inserisci un numero di matricola valido, ci sono caratteri non permessi nel campo matricola");
    		
    		return;
    		
    	}
    	
    	Studente s = model.getStudente(matricola);
    	
    	if(s == null) {
    		txtResult.setText("Matricola non presente");
    		return;
    	}
    	
    	for(Corso c : model.getCorsiByStudente(matricola)) {
    		
    		txtResult.appendText(c.getCodins() + " " + c.getCrediti() + " " + c.getNome() + " " + c.getPeriodo() + "\n");
    	}
    	
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    	txtResult.clear();
    	
    	Corso corso = this.cmbCorsi.getValue();
    	
    	if(corso == null) {
    		txtResult.setText("Inserisci un corso");
    		return;
    	}
    	
    	List<Studente> lista = model.getAllStudentiCorso(corso);
    	
    	if(lista.isEmpty()) {
    		txtResult.setText("Non ci sono studenti iscritti al corso");
    		return;
    	}
    	
    	for(Studente s : lista) {
    		txtResult.appendText(s + "\n");
    	}
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    	txtResult.clear();
    	
    	String input = txtMatricola.getText();
    	
    	int matricola = 0;
    	
    	try {
    		
    		matricola = Integer.parseInt(input);
    		
    	} catch(NumberFormatException e) {
    		
    		txtResult.setText("Inserisci un numero di matricola valido, ci sono caratteri non permessi nel campo matricola");
    		
    		return;
    		
    	}
    	
    	Corso corso = this.cmbCorsi.getValue();
    	
    	if(corso == null) {
    		txtResult.setText("Inserisci un corso");
    		return;
    	}
    	
    	Studente s = model.getStudente(matricola);
    	
    	if(s == null) {
    		txtResult.setText("Studente non trovato!");
    		return;
    	}
    	
    	boolean res = model.isIscritto(s, corso);
    	
    	if(!res) {
    		txtResult.setText("Studente già iscritto a questo corso");
    	} else {
    		
    		txtResult.setText("Studente iscritto al corso!");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtResult.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	this.cmbCorsi.setValue(null);
    }

    @FXML
    void doTickGreen(ActionEvent event) {

    	txtResult.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	String input = txtMatricola.getText();
    	
    	int matricola = 0;
    	
    	try {
    		
    		matricola = Integer.parseInt(input);
    		
    	} catch(NumberFormatException e) {
    		
    		txtResult.setText("Inserisci un numero di matricola valido, ci sono caratteri non permessi nel campo matricola");
    		
    		return;
    		
    	}
    	
    	Studente s = model.getStudente(matricola);
    	
    	if(s == null) {
    		txtResult.setText("Studente non trovato!");
    		return;
    	}
    	
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	
    }

    
    @FXML
    void initialize() {
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTick != null : "fx:id=\"btnTick\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    
    public void setModel() {
    	this.model = new Model();
    	
    	this.cmbCorsi.getItems().add(null);
    	
    	for(Corso c : this.model.getAllCorsi()) {
    		this.cmbCorsi.getItems().add(c); //c.getNome()
    	}
    	
    }

    
}
