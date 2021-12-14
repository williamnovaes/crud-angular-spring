package br.com.will.crudspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.will.crudspring.model.Course;
import br.com.will.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	//metodo apenas para exemplo para carregar o banco no inicio do desenvolvimento
	@Bean //anotacao que diz que o spring gerencia todo o ciclo de vida
	CommandLineRunner initDatabase(CourseRepository courseRepository) { //metodo que sera executado assim que o projeto for inicializado
		return args -> {
			courseRepository.deleteAll();
			List<Course> courses = new ArrayList<Course>();
			courses.add(new Course("Spring", "backend"));
			courses.add(new Course("Angular", "frontend"));
			courses.add(new Course("Javascript", "frontend"));
			courses.add(new Course("C#", "backend"));
			courses.add(new Course("Delphi", "backend"));
			courses.add(new Course("Html", "marcacao"));
			courseRepository.saveAll(courses);
		};
	}
}
