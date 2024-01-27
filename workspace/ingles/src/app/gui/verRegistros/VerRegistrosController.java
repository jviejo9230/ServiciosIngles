package app.gui.verRegistros;

import java.awt.Label;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.spi.RegisterableService;

import app.gui.AppController;
import app.gui.services.RegistroService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class VerRegistrosController extends AppController {
	@FXML
	private TableColumn<Map<LocalDate, String>, LocalDate> columnaFecha;

	@FXML
	private TableColumn<Map<LocalDate, String>, String> columnaRegistro;

	@FXML
	private BorderPane panel;

	@FXML
	private TableView<Map<LocalDate, String>> tabla;

	private ObservableList<Map<LocalDate, String>> datos;

	@FXML
	private DatePicker date;
	
	@FXML
	private Label label;

	@FXML
	void setTabla(ActionEvent event) {
		Map<LocalDate, String> mapa = new HashMap<LocalDate, String>();
		mapa.put(LocalDate.now(), "hola");
		mapa.put(LocalDate.of(2014, 3, 24), "dfadad");
		mapa.put(LocalDate.of(2018, 7, 12), "hofafwwadawdla");
		mapa.put(LocalDate.of(2023, 9, 2), "dqwfg3wtgw");
		mapa.put(LocalDate.of(2024, 1, 5), "gr4etg4etgw3");
		List<Map<LocalDate, String>> lista = new ArrayList<Map<LocalDate, String>>();
		lista.add(mapa);

		List<Map<LocalDate, String>> resultados = lista;
		datos.setAll(resultados);
	}

	public void initialize() {
		PropertyValueFactory<Map<LocalDate, String>, LocalDate> factoryValueFecha = new PropertyValueFactory<Map<LocalDate, String>, LocalDate>(
				"fecha");
		PropertyValueFactory<Map<LocalDate, String>, String> factoryValueRegistro = new PropertyValueFactory<Map<LocalDate, String>, String>(
				"registro");

		columnaFecha.setCellValueFactory(factoryValueFecha);
		columnaRegistro.setCellValueFactory(factoryValueRegistro);

		datos = FXCollections.observableArrayList();
		tabla.setItems(datos);

	}
	
	@FXML
	public void consultarRegistros() {
		RegistroService service = new RegistroService();
		List<String> tareas = service.consultarFecha(date.getValue());
	    for (String string : tareas) {
			label.setText(string);
		}
	}

}
