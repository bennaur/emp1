package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Employee;
import models.Contratto;

public class AddController implements Initializable {

    @FXML
    private ImageView imgBack;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCognome;

    @FXML
    private TextField tfEtà;

    @FXML
    private RadioButton rbIndet;

    @FXML
    private RadioButton rbPart;
    
    @FXML
    private Button buttonAdd;
    
    
  //Questo metodo riporta alla scena precedente
    @FXML
   public void backPushed(MouseEvent event) throws IOException {
    	
    	Parent parnt = FXMLLoader.load(getClass().getResource("/visual/update.fxml"));
   		Scene snc= new Scene(parnt);
    		
   		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
   		window.setScene(snc);
    	window.show();
    			
    }
  //Questo metodo creerà un nuovo dipendente e lo aggiungerà  alla lista
    
    public void addButtonPushed(ActionEvent event) {
    	//verifica della selezione dei radio buttons per determinare tipologia del contratto
    	
    	Contratto con= null;
    	if(rbIndet.isSelected()) {
    		con= Contratto.indeterminato;
    	}
    	
    	if(rbPart.isSelected()) {
    		con= Contratto.part_time;
    	}
    	
    	// verifica che tutti i campi siano stati compilati e relativo alert
    	if(tfNome.getText()== null || tfCognome.getText()== null || tfEtà.getText()== null || con== null 
    		|| tfNome.getText().isBlank() || tfCognome.getText().isBlank() || tfEtà.getText().isBlank() )
    		
    			{
    		
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Errore: Dipendente non aggiunto");
    		alert.setContentText("Errore: Dipendente non aggiunto");
    		alert.showAndWait();
    		return;
    	}
    	
   	//creazione di nuovo dipendente tramite dati immessi e aggiunta dello stesso
    	try {
    		
    	ViewController.getEmp().add(new Employee(tfNome.getText(), tfCognome.getText(), 
    								Integer.parseInt(tfEtà.getText()),con ));
    	}
    	
    	//errore immissione dati
    	catch(Exception e) {
    		
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Errore: Dipendente non aggiunto");
    		alert.setContentText("Errore: Dipendente non aggiunto");
    		alert.showAndWait();
    		return;
	
    	}
    	
    	//alert di conferma aggiunta dipendente
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Dipendente aggiunto correttamente");
		alert.setContentText("Dipendente aggiunto correttamente");
		alert.showAndWait();
		return;
    	
    	
    }

	@Override // impostare radiobuttons dimodochè si possa scegliere solo una tipologia di contratto
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ToggleGroup lav = new ToggleGroup();
		rbIndet.setToggleGroup(lav);
		rbPart.setToggleGroup(lav);
		
		
		
	}

}
