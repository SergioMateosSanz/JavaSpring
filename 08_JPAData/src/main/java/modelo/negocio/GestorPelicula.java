package modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {

	@Autowired
	private DaoPelicula daoPelicula;

	// aqui indicamos a Spring que lleve el control transaccional en este metodo si
	// no existe,
	// si existe la reutilizamos
	// cuando salgamos del metodo se cerrara la transaccion. si en algun momento
	// ocurre una
	// excepcion, se realizara un rollback y no se persistira nada
	@Transactional
	public int insertar(Pelicula p) {
		// aqui tendriamos que aplicar todas las reglas de negocio
		Pelicula paux = daoPelicula.save(p);
		// es posible que aqui pudieramos llamar a otros gestores de la aplicacion
		return paux.getId();
	}

	@Transactional
	public Pelicula modificar(Pelicula p) {
		return daoPelicula.save(p);
	}

	@Transactional
	public void borrar(int id) {
		daoPelicula.deleteById(id);
	}

	public Pelicula acceder(int id) {
		Optional<Pelicula> pOptional = daoPelicula.findById(id);
		if (pOptional.isPresent()) {
			return pOptional.get();
		} else {
			return null;
		}
	}

	public List<Pelicula> listar() {
		return daoPelicula.findAll();
	}
}
