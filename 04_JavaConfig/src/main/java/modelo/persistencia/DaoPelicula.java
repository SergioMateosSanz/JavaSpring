package modelo.persistencia;

import java.util.List;

import modelo.entidades.Pelicula;

public class DaoPelicula {

	private List<Pelicula> listaPeliculas;
	
	/**
	 * Metodo que persiste en memoria la pelicula
	 * @param p representa la pelicula a guardar
	 * @return true en casa de se haya insertado, false en caso contrario
	 */
	
	public boolean insertar(Pelicula p) {
		return listaPeliculas.add(p);
	}

	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	
}
