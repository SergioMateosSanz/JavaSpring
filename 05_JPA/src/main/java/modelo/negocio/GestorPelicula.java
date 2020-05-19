package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	private DaoPelicula daoPelicula; 
	
	// aqui indicamos a Spring que lleve el control transaccional en este metodo si no existe,
	//si existe la reutilizamos
	//cuando salgamos del metodo se cerrara la transaccion. si en algun momento ocurre una 
	//excepcion, se realizara un rollback y no se persistira nada
	@Transactional
	public int insertar(Pelicula p) {
		//aqui tendriamos que aplicar todas las reglas de negocio
		int id = daoPelicula.insertar(p);
		//es posible que aqui pudieramos llamar a otros gestores de la aplicacion
		return id;
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return daoPelicula.modificar(p);
	}
	
	@Transactional
	public int borrar(int id) {
		return daoPelicula.borrar(id);
	}
	
	public Pelicula acceder(int id) {
		return daoPelicula.acceder(id);
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.listar();
	}
}
