package es.curso.ejemplo3;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEjemplo3 {
	
	public static ApplicationContext context = 
			new ClassPathXmlApplicationContext("beansColecciones.xml");
	
	public static void main(String[] args) {
		//usamos astraccion utilizando la interfaz List
		List<String> listaNombres = context.getBean("listaNombres", List.class);
		System.out.println(listaNombres);
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		System.out.println(listaPersonas);
		//usamos astraccion utilizando la interfaz Map
		Map<String, Persona> mapaPersonas = context.getBean("mapaPersonas", Map.class);
		
		System.out.println(mapaPersonas.get("persona1"));
		Persona p = context.getBean("personaBean2", Persona.class);
		mapaPersonas.put("persona3", p);
	}
}
