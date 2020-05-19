package es.curso.ejemplo0;

public class FactoriaArmas {

	public Arma crearArmas(String tipoArma) {
		switch (tipoArma) {
		case "arco":
			return new Arco();
		case "espada":
			return new Espada();
		default:
			return null;
		}
	}

}
