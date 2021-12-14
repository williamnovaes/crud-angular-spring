package br.com.will.crudspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.will.crudspring.model.Course;
import br.com.will.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;

@RestController  //representa que essa classe possui um end point (é um servlet)
@RequestMapping("/api/courses")
@AllArgsConstructor //cria um construtor com o course repository, fazendo deste obrigatorio para uso do controller
public class CursosController {

    private final CourseRepository courseRepository;
    
    @GetMapping //mesmo que gazer o doGet do servlet
    //@RequestMapping(method = RequestMethod.GET)
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}") //mesmo que gazer o doGet do servlet
    //@RequestMapping(method = RequestMethod.GET)
    public Optional<Course> listById(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

    @PostMapping //mesmo que fazer o doGet do servlet
    //@RequestMapping(method = RequestMethod.GET)
    public String post(@RequestBody Course course) {
        if (course != null) {
            courseRepository.save(course);
            return new StringBuilder("Curso ").append(course.getName()).append(" cadastrado com sucesso!").toString();
        }

        return "Erro ao salvar";
    }
}
