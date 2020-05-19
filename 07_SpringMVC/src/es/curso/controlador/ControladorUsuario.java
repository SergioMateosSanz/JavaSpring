package es.curso.controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.negocio.GestorUsuario;

@Controller
public class ControladorUsuario {

	//intenta un autowired por tipo y si hay varios, intenta un autowired por nombre
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private ApplicationContext context;
	//en este caso tenemos ya disponible el contexto, lo que hacemos es referenciarlo 
	
	@Autowired
	private GestorUsuario gp;
	
	// url http://localhost:8080/07_SpringMVC/mvc/validarUsuario para que pase por el 
	//FaceController
	@RequestMapping("validarUsuario")
	public String validar(HttpServletRequest request, @RequestParam("nombre") String nombre, 
			@RequestParam("password") String password) {
		System.out.println(nombre);
		System.out.println(password);
		System.out.println(request.getParameter("nombre"));
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		gp.validarUsuario(usuario);
		if (usuario.isValidado()) {
			return "inicio";//forward
		} else {
			return "redirect:/index.html";//redireccionamiento (no pasa por el viewResolver)
		}
	}
}
