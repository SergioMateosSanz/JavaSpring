package es.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Esta etiqute engloba otras 3
//@Configuration, esta eiqueta hacer que esta classe pueda tener metodos anotados con @BEan
//@ComponenteScan
//EnabledAutoConfiguration, que este etiqueta habilita toda la configuracion por defecto
//entre otras lo que hace es escaner nuestro classpath y dar de alta objetos que spring necesitara
@SpringBootApplication
public class Ej09SpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ej09SpringBootApplication.class, args);
		DaoPersona daoPersona = context.getBean("daoPersona",DaoPersona.class);
		Persona persona = new Persona();
		persona.setNombre("Carpanta");
		
		daoPersona.save(persona);
		
		System.out.println(daoPersona.findById(1));
		System.out.println(daoPersona.findById(persona.getId()));
	}
	
	

}
