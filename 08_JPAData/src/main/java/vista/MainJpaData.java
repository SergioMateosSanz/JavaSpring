 package vista;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidad.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;

public class MainJpaData {
	public static ApplicationContext context =
			new AnnotationConfigApplicationContext(Configuracion.class);
	
	public static void main(String[] args) {
		System.out.println("Arrancando bbdd");

		Pelicula p = context.getBean("pelicula",Pelicula.class);
		p.setTitulo("El retorno del jedi");
		p.setDirector("George Lucas");
		p.setGenero("Sci-fi");
		p.setYear(1983);
		
		GestorPelicula gp = context.getBean("gestorPelicula",GestorPelicula.class);
		int id = gp.insertar(p);
		System.out.println("id insertado: " + id);
		System.out.println(gp.acceder(1));
		
		p.setTitulo("El amaperio contra paca");
		
		gp.modificar(p);
		
		System.out.println(gp.acceder(1));
		
		//esto modifica todo el objeto, es decir deja campos a vacio en
		//la bbdd
		//p = new Pelicula();
		p = gp.acceder(1);
		//p.setId(1);
		p.setTitulo("La guerra de las galaxias");
		
		gp.modificar(p);
		System.out.println(gp.acceder(1));
		
		//gp.borrar(1);
		DaoPelicula daoPelicula = context.getBean("daoPelicula", DaoPelicula.class);
		System.out.println(daoPelicula.findByTitulo("La guerra de las"));
		System.out.println(daoPelicula.findByTituloContaining("La guerra de las"));
		System.out.println(daoPelicula.findByLoQueSea(1990));
		//System.out.println(gp.listar());
	}
}