package es.curso.ejemplo1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEjemplo1 {
	
	public static ApplicationContext context = 
			new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		Persona p1 = (Persona) context.getBean("personaBean");
		p1.setEdad(34);
		p1.setNombre("Hommer");
		p1.setPeso(84.4);
		
		Persona p2 = context.getBean("personaBean",Persona.class);
		System.out.println(p2);
		
		Persona p3 = context.getBean("personaPrototype",Persona.class);
		System.out.println(p3);
		Persona p5 = context.getBean("personaBean2", Persona.class);
		System.out.println(p5);
		
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		listaPersonas.add(p3);
		p3=null;//p3 apunta a null, pero el objeto no se pierde porque antes lo meti en la lista
		p3 = context.getBean("personaPrototype", Persona.class);
		
		Persona p6 = context.getBean("personaConstructor", Persona.class);
		listaPersonas.add(p6);
		metodo1();
		
		p6 = context.getBean("flander", Persona.class);
		System.out.println(p6);
		p6 = context.getBean("m_flander", Persona.class);
		System.out.println(p6);
		p6 = context.getBean("persona", Persona.class);
		p6.setNombre("Milhouse");
		p6.setEdad(11);
		p6.getDireccion().setCiudad("Springfield");//al ser objeto persona ya definido con un
		//objeto direccion linkado podemos acceder a el
		System.out.println(p6);
	}
	
	private static void metodo1() {
		List<Persona> listaPersonas= context.getBean("listaPersonas", List.class);
		System.out.println("Metodo1-> " + listaPersonas);
		metodo2();
	}
	private static void metodo2() {
		List<Persona> listaPersonas= context.getBean("listaPersonas", List.class);
		System.out.println("Metodo2-> " + listaPersonas);
	}
}
