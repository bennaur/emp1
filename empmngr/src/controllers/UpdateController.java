package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdateController {

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgAgg;

    @FXML
    private ImageView imgElim;
    

  //Questo metodo riporta alla scena precedente
    @FXML
	public void backPushed(MouseEvent event) throws IOException {
		
		Parent parnt = FXMLLoader.load(getClass().getResource("/visual/stage1.fxml"));
		Scene snc= new Scene(parnt);
		
		
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(snc);
		window.show();
		
	}
    
  //Questo metodo porta alla scena aggiungi dipendente
    
	public void addPushed(MouseEvent event) throws IOException {
		
		Parent parnt = FXMLLoader.load(getClass().getResource("/visual/add.fxml"));
		Scene snc= new Scene(parnt);
		
		
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(snc);
		window.show();
		
	}
	
	  //Questo metodo porta alla scena elimina dipendente
    
		public void delPushed(MouseEvent event) throws IOException {
			
			Parent parnt = FXMLLoader.load(getClass().getResource("/visual/delete.fxml"));
			Scene snc= new Scene(parnt);
			
			
			Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(snc);
			window.show();
			
		}


}
