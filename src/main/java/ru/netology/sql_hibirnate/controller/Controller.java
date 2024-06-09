package ru.netology.sql_hibirnate.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sql_hibirnate.model.Person;
import ru.netology.sql_hibirnate.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
public class Controller {
    Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(String city){
        List<?> persons = repository.findByCityOfLiving(city);
        return (List<Person>) persons;
    }

    @GetMapping("/less-age")
    public List<Person> getPersonsLessAge(Integer age){
        return repository.findByAgeLessThanOrderByAge(age, Sort.by("id.age"));

    }

    @GetMapping("/by-name-surname")
    public List<Person> getPersonsByNameSurname(String name, String surname){
        return repository.findByNameAndSurnameLike(name, surname);
    }


}
