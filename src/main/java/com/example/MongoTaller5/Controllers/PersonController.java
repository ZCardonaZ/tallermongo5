package com.example.MongoTaller5.Controllers;
import com.example.MongoTaller5.Models.Person;
import com.example.MongoTaller5.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> crear(@RequestBody Person person) {
        if (person.getCreateAt() == null) {
            person.setCreateAt(new Date());
        }
        Person personBd = personService.save(person);
        return ResponseEntity.ok(personBd);
    }

    @PutMapping("/cell-number")
    public ResponseEntity<Person> updateCellNumber(@RequestBody Person person) {
        Person updatedPerson = personService.updateCellNumber(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @PutMapping("/address")
    public ResponseEntity<Person> updateAddress(@RequestBody Person person) {
        Person updatedPerson = personService.updateAddress(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @PutMapping("/email")
    public ResponseEntity<Person> updateEmailAddress(@RequestBody Person person) {
        Person updatedPerson = personService.updateEmailAddress(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = personService.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/upper-case")
    public ResponseEntity<List<Person>> findAllConNombreUpperCase() {
        List<Person> persons = personService.findAllConNombreUpperCase();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/upper-case-repeat")
    public ResponseEntity<List<Person>> findAllConNombreUpperCaseRepeat() {
        List<Person> persons = personService.findAllConNombreUpperCaseRepeat();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable String id) {
        Person person = personService.findById(id);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = personService.delete(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}


