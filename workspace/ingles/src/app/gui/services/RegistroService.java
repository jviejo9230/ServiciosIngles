package app.gui.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import app.gui.modelo.Registro;

public class RegistroService {

	public RegistroService() {
	}

//	public Registro crearRegistro(LocalDate fecha, String tareas, List<Registro> registros) throws RegistrosException {
//		Registro reg = new Registro();
//		if (registros.isEmpty()) {
//			reg.setFecha(fecha);
//			reg.getRegistros().add(tareas);
//
//		} else {
//
//			for (Registro r : registros) {
//				if (r.getFecha() == fecha) {
//					throw new RegistrosException("Ya hay registros para ese día");
//				} else {
//					reg.setFecha(fecha);
//					reg.getRegistros().add(tareas);
//				}
//			}
//		}
//		return reg;
//	}
//
//	public List<Registro> consultarRegistros(List<Registro> registros) throws RegistrosException {
//		if (registros != null) {
//			return registros;
//
//		} else {
//			throw new RegistrosException("Error al consultar registros");
//		}
//
//	}
//
//	public void borrarRegistro(LocalDate fecha, List<Registro> registros) throws RegistrosException {
//		for (Registro registro : registros) {
//			if (registro.getFecha() == fecha) {
//				registros.remove(registro);
//			} else {
//				throw new RegistrosException("Error al borrar registros");
//			}
//		}
//	}
//
//	public void actualizarRegistro(LocalDate fecha, String tareaNueva, List<Registro> registros)
//			throws RegistrosException {
//		for (Registro registro : registros) {
//			if (registro.getFecha() == fecha) {
//				registro.getRegistros().add(tareaNueva);
//			} else {
//				throw new RegistrosException("Error al actualizar registros");
//			}
//		}
//	}
	
	
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
