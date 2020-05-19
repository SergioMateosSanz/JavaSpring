package es.curso.ejemplo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEjemplo2 {

	public static ApplicationContext context = 
			new ClassPathXmlApplicationContext("guerra.xml");
	
	public static void main(String[] args) {
		Guerrero conan = context.getBean("conan", Guerrero.class);
		conan.atacar();
		Guerrero legolas = context.getBean("legolas", Guerrero.class);
		legolas.atacar();
	}

}
