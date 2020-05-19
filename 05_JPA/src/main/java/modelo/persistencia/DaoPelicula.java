package modelo.persistencia;

import java.util.List;

import modelo.entidad.Pelicula;

public interface DaoPelicula {
	
	/**
	 * metodo para dar de alta una pelicula
	 * @param p la pelicula a insertar
	 * @return int: el id de la pelicula insertada
	 */
	public int insertar(Pelicula p);
	/**
	 *  metodo para modificar una pelicula
	 * @param p la pelicula a modificar
	 * @return Pelicula: la pelicula modificada
	 */
	public Pelicula modificar(Pelicula p);
	public int borrar(int id);
	/**
	 * metodo de consulta de una pelicula
	 * @param id el id de la pelicula a consultar
	 * @return Pelicula: la pelicula recuperada
	 */
	public Pelicula acceder(int id);
	public List<Pelicula> listar();
	
	
}
