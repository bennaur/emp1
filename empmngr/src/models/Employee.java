package models;

import javafx.beans.property.SimpleStringProperty;

public class Employee {


	private SimpleStringProperty nome;
	private SimpleStringProperty cognome;
	private int età;
	private Contratto contr;
	
	public Employee(String nome, String cognome, int età, Contratto contr) {
		
		this.nome = new SimpleStringProperty( nome);
		this.cognome =new SimpleStringProperty(cognome);
		this.età = età;
		this.contr = contr;
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(SimpleStringProperty nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome.get();
	}

	public void setCognome(SimpleStringProperty cognome) {
		this.cognome = cognome;
	}

	public int getEtà() {
		return età;
	}

	public void setEtà(int età) {
		this.età = età;
	}

	public Contratto getContr() {
		return contr;
	}

	public void setContr(Contratto contr) {
		this.contr = contr;
	}
	
	
	
	
}
