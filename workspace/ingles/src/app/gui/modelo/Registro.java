package app.gui.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Registro {
	private List<String> registros;
	private LocalDate fecha;

	public Registro() {
		registros = new ArrayList<String>();
	}

	public List<String> getRegistros() {
		return registros;
	}

	public void setRegistros(List<String> registros) {
		this.registros = registros;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Registro [registros=" + registros + "]";
	}

}
