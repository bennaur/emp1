package controllers;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Stage1Controller {

    @FXML
    private Label labelTitle;

    @FXML
    private ImageView imgView;

    @FXML
    private ImageView imgUpdate;

    @FXML
    private Label lablview;

    @FXML
    private Label lablUpd;



// Quando questo metodo viene chiamato, cambia la scena
    
public void viewPushed(MouseEvent event) throws IOException {
	
	Parent parnt = FXMLLoader.load(getClass().getResource("/visual/view.fxml"));
	Scene snc= new Scene(parnt);
	
	
	Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
	window.setScene(snc);
	window.show();
	
	
	
}

//Quando questo metodo viene chiamato, porta alla scena update

public void updatePushed(MouseEvent event) throws IOException {
	
	Parent parnt = FXMLLoader.load(getClass().getResource("/visual/update.fxml"));
	Scene snc= new Scene(parnt);
	
	
	Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
	window.setScene(snc);
	window.show();
	
	
	
}

}