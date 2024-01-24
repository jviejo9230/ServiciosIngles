package ingles.proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ingles.proyecto.servicios.FechaException;
import ingles.proyecto.servicios.Servicios;


public class Test {
	
	public static void main(String[] args) {
		
		LocalDate fecha1 = LocalDate.of(2024,1,23);
		LocalDate fecha2 = LocalDate.of(2024,2,23);
		
		Servicios service = new Servicios();
		
		List<String> lista = new ArrayList<String>();
		lista.add("aaa");
		lista.add("bbbb");
		service.crearRegistro(fecha1, lista);
		

		System.out.println(service.consultarFecha(fecha1));
		
		//BIEN HASTA AQUI
		
		try {
			service.actualizarRegistro(fecha1, "aaa", "ccc");
		} catch (FechaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(service.consultarFecha(fecha1));
		try {
			service.borrarRegistro(LocalDate.of(2024,1,23), "aaa");
		} catch (FechaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BORRADO: " + service.consultarFecha(fecha1));
	}
}
