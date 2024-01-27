package app.gui.bienvenida;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

import app.gui.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;


public class BienvenidaController extends AppController {
    @FXML
    private DatePicker fecha;
    @FXML
    private BorderPane panel;
    
    @FXML
    private Label lblWelcome;
    @FXML
    LocalDate sacarFecha(ActionEvent event) {
    	DatePicker verFecha = fecha;
    	LocalDate fechabien = verFecha.getValue();
    	System.out.println(fechabien);
    	return fechabien;
    }
    
    
    @FXML
    void irDelete(ActionEvent event) {
    	panel.setCenter(cargarVista(FXML_DELETE));
    }

    @FXML
    void irModificar(ActionEvent event) {
    	panel.setCenter(cargarVista(FXML_MODIFICAR));
    }
    @FXML
    void irNuevo(ActionEvent event) {
//    	NewEntryController nec =new NewEntryController();
//    	nec.setFecha(event);
    	panel.setCenter(cargarVista(FXML_NEW));
    }
    @FXML
    void irVer(ActionEvent event) {
    	panel.setCenter(cargarVista(FXML_VIEW));
    }

//    @FXML
//    void salir(ActionEvent event) {
//    	cambiarVista(AppController.FXML_LOGIN);
//    }
}
