package ingles.proyecto.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

public class Servicios {
	
	private static Map<LocalDate, List<String>> bbdd = new HashMap<LocalDate, List<String>>();

	
	
	public void crearRegistro(LocalDate fecha, List<String> listaTareas) {
		
		bbdd.put(fecha, listaTareas);
	}
	
	
	public void borrarRegistro(LocalDate fecha, String tarea) throws FechaException {
		Set<Entry<LocalDate, List<String>>> pares = bbdd.entrySet();

		for (Entry<LocalDate, List<String>> par : pares) {
			if(par.getKey() == fecha) {
				for (String tareas : par.getValue()) {
					
					if(tarea.equals(tareas)) {
//						Iterator<String> iterador = tareas.iterator();
//						pares.remove(tareas);
					}
				}
			}
			else {
				throw new FechaException("Error al borrar, la fecha o tarea no existe en la base de datos");
			}
		}
	}
	
	public void actualizarRegistro(LocalDate fecha, String tareaVieja, String tareaNueva) throws FechaException {
		
		Set<Entry<LocalDate, List<String>>> pares = bbdd.entrySet();

		for (Entry<LocalDate, List<String>> lista : pares) {
			
			if(lista.getKey() == fecha) {
				
				for (String tarea : lista.getValue()) {
					
					if(tarea.equals(tareaVieja)) {
						
						
						tarea=tareaNueva; //MAL
					}
				}
			}
			else {
				throw new FechaException("Error al borrar, la fecha o tarea no existe en la base de datos");
			}
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
