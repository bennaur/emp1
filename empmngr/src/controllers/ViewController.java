package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Contratto;
import models.Employee;

public class ViewController implements Initializable{

	//Configurazione tabella
	
	private static ObservableList<Employee> emp= FXCollections.observableArrayList();
	
	
	
    @FXML
    private TableView<Employee> tvDip;

    @FXML
    private TableColumn<Employee, SimpleStringProperty> colNome;

    @FXML
    private TableColumn<Employee, SimpleStringProperty> colCognome;

    @FXML
    private TableColumn<Employee, Integer	> colEtà;

    @FXML
    private TableColumn<Employee, Contratto> colContratto;

    @FXML
    private ImageView imgBack;
    
    
    
    // Inizializza la tabella
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Impostazione colonne 
		
		colNome.setCellValueFactory(new PropertyValueFactory<Employee, SimpleStringProperty>("nome"));
		colCognome.setCellValueFactory(new PropertyValueFactory<Employee, SimpleStringProperty>("cognome"));
		colEtà.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("età"));
		colContratto.setCellValueFactory(new PropertyValueFactory<Employee, Contratto>("contr"));
		
		//Caricamento dati 
		
		tvDip.setItems(getEmp());
		
	}
	
	
	//Questo metodo  ritorna la lista dei dipendenti
	
	public static  ObservableList<Employee> getEmp() {

		return emp;
		
	}
	
	//Questo metodo riporta alla scena precedente
	
	public void backPushed(MouseEvent event) throws IOException {
		
		Parent parnt = FXMLLoader.load(getClass().getResource("/visual/stage1.fxml"));
		Scene snc= new Scene(parnt);
		
		
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(snc);
		window.show();
		
	}

}
