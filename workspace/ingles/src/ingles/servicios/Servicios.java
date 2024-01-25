package ingles.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.Set;

public class Servicios {
	
	private static Map<LocalDate, List<String>> bbdd = new HashMap<LocalDate, List<String>>();

	
	
	public void crearRegistro(LocalDate fecha, List<String> listaTareas) {
		
		bbdd.put(fecha, listaTareas);
	}
	
	
	public void borrarRegistro(LocalDate fecha, String tarea) throws FechaException {
		if(bbdd.containsKey(fecha)) {
			List<String> lista = bbdd.get(fecha);
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).equals(tarea)) {
					lista.remove(i);
					break;
				}
			}
		}
		else {
			throw new FechaException("Error al actualizar, la fecha o tarea no existe en la base de datos");
		}
	}
	
	public void actualizarRegistro(LocalDate fecha, String tareaVieja, String tareaNueva)throws FechaException {
		if(bbdd.containsKey(fecha)) {
			List<String> lista = bbdd.get(fecha);
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).equals(tareaVieja)) {
					lista.set(i, tareaNueva);
					break;
				}
			}
		}
		else {
			throw new FechaException("Error al actualizar, la fecha o tarea no existe en la base de datos");
		}
	}
	
	public List<String> consultarFecha(LocalDate fecha){
		Set<LocalDate> fechas = bbdd.keySet();
		List<String> tarea = new ArrayList<>();
		for (LocalDate key : fechas) {
			
			tarea = bbdd.get(fecha);
		}
		
		return tarea;

	}
}