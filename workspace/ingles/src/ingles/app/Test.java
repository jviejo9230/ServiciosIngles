package ingles.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ingles.servicios.FechaException;
import ingles.servicios.Servicios;




public class Test {
	
	public static void main(String[] args) {
		// Crear registro
		LocalDate fecha1 = LocalDate.of(2024,1,23);
		LocalDate fecha2 = LocalDate.of(2024,2,23);
		
		Servicios service = new Servicios();
		
		List<String> lista = new ArrayList<String>();
		lista.add("aaa");
		lista.add("bbbb");
		System.out.println("Insertando registros...");
		service.crearRegistro(fecha1, lista);
		
		//Consultar registro
		System.out.println("Registros para la fecha "+ fecha1 + ": " + service.consultarFecha(fecha1));
		
		//Actualizar registro
		try {
			System.out.println("Actualizando registros...");
			service.actualizarRegistro(fecha1, "aaa", "ccc");
		} catch (FechaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Consultar registro actualizado
		System.out.println("Registros para la fecha "+ fecha1 + ": " + service.consultarFecha(fecha1));
		
		//Borrar registro 
		try {
			System.out.println("Borrando registros...");
			service.borrarRegistro(LocalDate.of(2024,1,23), "bbbb");
		} catch (FechaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Registros para la fecha "+ fecha1 + ": " + service.consultarFecha(fecha1));
	}
}