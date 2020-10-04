package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Employee;

public class DeleteController implements Initializable{

	
	//Configurazione tabella
	

		
	
	
   

    @FXML
    private TableView<Employee> tvDel;

    @FXML
    private TableColumn<Employee, SimpleStringProperty> colNome;

    @FXML
    private TableColumn<Employee, SimpleStringProperty> colCognome;

    @FXML
    private ImageView imgBack;

    @FXML
    private Button buttonDel;	

    //Questo metodo riporta alla scena precedente

    @FXML
   public void backPushed(MouseEvent event) throws IOException {
    	
    	Parent parnt = FXMLLoader.load(getClass().getResource("/visual/update.fxml"));
   		Scene snc= new Scene(parnt);
    		
   		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
   		window.setScene(snc);
    	window.show();
    }
    
    //Questo metodo elimina i dipendenti selezionati

    @FXML
    public void delButtonPushed(Event event) {

    	ObservableList<Employee> selectedRows, allEmp;
    	
    	//lista di tutti i dipendenti
    	allEmp= tvDel.getItems();
    	
    	// lista dei dipendenti selezionati
    	selectedRows= tvDel.getSelectionModel().getSelectedItems();
    	
    	// rimozione dei dipendenti nella lista dei selezionati dalla lista di tutti i dipendenti
    	 
    	allEmp.removeAll(selectedRows);
    	
    	
    }

	@Override // questo metodo recupera i dati della tabella originale con Nome e Cognome dei dipendenti
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		colNome.setCellValueFactory(new PropertyValueFactory<Employee, SimpleStringProperty>("nome"));
		colCognome.setCellValueFactory(new PropertyValueFactory<Employee, SimpleStringProperty>("cognome"));
		
		tvDel.setItems(ViewController.getEmp());
		
		// conferisce la capacità di selezionare molteplici righe della tabella
		tvDel.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	


}
