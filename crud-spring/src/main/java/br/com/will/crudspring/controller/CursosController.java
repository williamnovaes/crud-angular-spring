package br.com.will.crudspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
