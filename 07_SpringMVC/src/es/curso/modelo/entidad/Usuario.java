package es.curso.modelo.entidad;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope()
public class Usuario {

	private String nombre;
	private String password;
	private boolean validado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + ", validado=" + validado + "]";
	}

}
