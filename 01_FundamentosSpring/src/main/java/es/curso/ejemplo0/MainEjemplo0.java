package es.curso.ejemplo0;

public class MainEjemplo0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoriaArmas fa = new FactoriaArmas();
		
		Guerrero g = new Guerrero();
		g.setNombre("Aquiles");
		g.setArma(fa.crearArmas("espada"));
		g.atacar();
		
		Guerrero g2 = new Guerrero();
		g2.setNombre("George Clooney");
		Arma arco = fa.crearArmas("arco");
		arco.setTipo("arco corto");
		g2.setArma(arco);
		g2.atacar();
	}

}
