package app.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController appController = new AppController(primaryStage);
		appController.cambiarVista(AppController.FXML_BIENVENIDA);
		//mostrar escenario
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
