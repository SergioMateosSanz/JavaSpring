package modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modelo.entidad.Pelicula;

//tenemos que decirle solamente la entidad que queremos persistir y el tipo de su PK
//esto simplemente nos crea un CRUD de acceso a datos (y las tablas por JPA si no existen)
public interface DaoPelicula extends JpaRepository<Pelicula, Integer> {

	// ademas podemos hacer mas metodos basandonos en convenciones
	// si empieza por findBy por debajo se generan las queries necesarias
	public List<Pelicula> findByTitulo(String titulo);

	public List<Pelicula> findByTituloAndGenero(String titulo, String genero);

	// para buscar una pelicula cuyo titulo contenga una palabra o una parte
	public List<Pelicula> findByTituloContaining(String titulo);

	//para no diferenciar entre mayusculas y minusculas
	public List<Pelicula> findByTituloIgnoreCaseContaining(String titulo);

	@Query("select p from Pelicula p where p.year > ?1")
	public List<Pelicula> findByLoQueSea(int year);
}
