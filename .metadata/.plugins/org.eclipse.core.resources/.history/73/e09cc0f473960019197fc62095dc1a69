package presentacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;


public class MainProyecto2 {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {

			Pelicula p = context.getBean("pelicula", Pelicula.class);
			p.setTitulo("Aladin");
			p.setGenero("fantasia");
			p.setYear(2019);
			p.getDirector().setId(1);
			p.getDirector().setNombre("George Lucas");
			p.setId(1);
			
			GestorPelicula gp = context.getBean("gestorPelicula", GestorPelicula.class);
			
			if (gp.insertar(p)) {
				System.out.println("La pelicula se ha insertado con exito");
			} else {
				System.out.println("Ha ocurrido algun error al insertar la pelicula");
			}
			
			p = context.getBean("pelicula", Pelicula.class);
			p.setTitulo("La guerra de las galaxias");
			p.setGenero("Sci-fi");
			p.setYear(1979);
			p.getDirector().setId(2);
			p.getDirector().setNombre("Walt Disney");
			p.setId(2);
			
			gp.insertar(p);
			
			System.out.println(gp.listar());
	}

}
