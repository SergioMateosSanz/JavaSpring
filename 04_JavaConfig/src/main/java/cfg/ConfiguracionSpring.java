package cfg;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;

public class ConfiguracionSpring {

	//Spring con esta anotacion va a invocar a este metodo para dar de alta un director.
	//Lo dara de alta con el id del nombre del metodo y de scope por defecto singleton
	@Bean("director")//aunque por defecto coge el nombre del metodo
	@Scope("prototype")
	public Director director() {
		Director d = new Director();
		d.setNombre("Steven");//el objeto prototypado tendra de nombre Steven
		return d;
	}
	
	//Sin especificar en el parametro de entrada Spring va a hacer un autowired por tipo
	//con @Qualifier en el parametro le especificamos cual queremos
	@Bean
	@Scope("prototype")
	public Pelicula pelicula(Director director) {
		Pelicula p = new Pelicula();
		p.setDirector(director);
		return p;
	}
	
	@Bean
	public DaoPelicula daoPelicula() {
		DaoPelicula daoPelicula = new DaoPelicula();
		daoPelicula.setListaPeliculas(new ArrayList<>());
		return daoPelicula;
	}
	
	@Bean
	public GestorPelicula gestorPelicula(DaoPelicula daoPelicula) {
		GestorPelicula gp = new GestorPelicula();
		gp.setDaoPelicula(daoPelicula);
		return gp;
	}
}
