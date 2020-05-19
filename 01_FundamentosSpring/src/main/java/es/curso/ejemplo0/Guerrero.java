package es.curso.ejemplo0;

public class Guerrero {
	private String nombre;
	private Arma arma;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public void atacar() {
		System.out.println("Soy el guerrero " + nombre + " y voy a atacar");
		arma.usar();
	}
}
