package app.gui;

import java.io.IOException;
import java.util.List;

import app.gui.modelo.Registro;
import app.gui.services.RegistroService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	private static List<Registro> registrosTotales;
	private RegistroService service;
	private static Stage stage;
	public static final String FXML_BIENVENIDA ="/app/gui/bienvenida/bienvenida.fxml";
	public static final String FXML_NEW ="/app/gui/bienvenida/newEntry.fxml";
	public static final String FXML_VIEW ="/app/gui/bienvenida/verRegistros.fxml";
	public static final String FXML_DELETE ="/app/gui/bienvenida/deleteEntry.fxml";
	public static final String FXML_MODIFICAR ="/app/gui/bienvenida/modifEntry.fxml";
	public AppController() {

	}

	public AppController(Stage primaryStage) {
		stage = primaryStage;
	}
	
	public AppController cambiarVista(String fxml) {
				try {
					//1. cargar el fxml
					FXMLLoader loader= new FXMLLoader(App.class.getResource(fxml));
					//2. creamos la escena
					Scene scene;
					scene = new Scene(loader.load());
					//3. cargar la escena en el escenario
					stage.setScene(scene);
					//4. devolvemos el controller
					return loader.getController();
				} catch (IOException e) {
					System.err.println("No se ha podido cambiar de vista");
					System.err.println("Vista destino: "+fxml);
					e.printStackTrace();
					throw new RuntimeException(e);
				}
	}
	
	public Parent cargarVista(String fxml) {
		try {
			//1. cargar el fxml
			FXMLLoader loader= new FXMLLoader(App.class.getResource(fxml));
			//2. creamos la escena
			return loader.load();
			
		} catch (IOException e) {
			System.err.println("No se ha podido cambiar de vista");
			System.err.println("Vista destino: "+fxml);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
}
//	public void crearRegistro(LocalDate fecha, String tarea) throws RegistrosException {
//		registrosTotales.add(service.crearRegistro(fecha, tarea, registrosTotales));
//	}
//
//	public List<Registro> consultarRegistros() throws RegistrosException {
//		return service.consultarRegistros(registrosTotales);
//	}
//
//	public static List<Registro> getRegistrosTotales() {
//		return registrosTotales;
//	}
	
	
}
