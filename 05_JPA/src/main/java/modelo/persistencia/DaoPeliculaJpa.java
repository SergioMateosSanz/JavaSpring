package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelo.entidad.Pelicula;

@Repository
public class DaoPeliculaJpa implements DaoPelicula{

	//esta anotacion invoca al contexto de persistencia de jpa (concretamente a la
	//factoria de entities manager) para crear un objeto EntityManager
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int insertar(Pelicula p) {
		System.out.println(p.getId());//aqui el id es 0 (debe ser 0)
		em.persist(p);
		System.out.println(p.getId());//aqui ya se ha actualizado con l valor de bbdd
		return p.getId();
	}

	@Override
	public Pelicula modificar(Pelicula p) {
		//sincroniza el objeto con la bbdd, si tiene id modifica si no lo tiene inserta
		Pelicula p2 = em.merge(p);
		//jpa solo se fia de los objetos que ha creado el, por que siempre
		//que se haga un merge siempre hara una copia
		return p2;
	}

	@Override
	public int borrar(int id) {
		//para borrar un objeto en jpa tiene que estar en la cache
		Pelicula p1 = acceder(id);
		em.remove(p1);
		return 0;
	}

	@Override
	public Pelicula acceder(int id) {
		Pelicula p = em.find(Pelicula.class, id);
		return p;
	}

	@Override
	public List<Pelicula> listar() {
		//para listar tenemos que apoyarnos en consultas JPQL
		return em.createQuery("select p from Pelicula p").getResultList();
	}

}