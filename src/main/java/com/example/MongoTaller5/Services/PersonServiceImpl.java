package com.example.MongoTaller5.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MongoTaller5.Repositories.PersonRepository;
import com.example.MongoTaller5.Models.Person;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository dao;


    @Override
    public Person save(Person person) {
        return dao.save(person);
    }

    @Override
    public List<Person> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Person> findAllConNombreUpperCase() {
        List<Person> persons = dao.findAll();
        persons.forEach(person -> person.setFirstName(person.getFirstName().toUpperCase()));
        return persons;
    }

    @Override
    public List<Person> findAllConNombreUpperCaseRepeat() {
        List<Person> persons = dao.findAll();
        persons.forEach(person -> {
            String upperCaseName = person.getFirstName().toUpperCase();
            person.setFirstName(upperCaseName + " " + upperCaseName);
        });
        return persons;
    }

    @Override
    public Person findById(String id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Person updateCellNumber(Person person) {
        Optional<Person> objPerson = dao.findById(person.getId());
        Person personBd = new Person();

        if(objPerson.isPresent()) {

            personBd = objPerson.get();
            personBd.setCellNumber(person.getCellNumber());
            dao.delete(personBd);
            dao.save(personBd);

        }
        return personBd ;
    }

    @Override
    public Person updateAddress(Person person) {
        return dao.findById(person.getId()).map(personBd -> {
            personBd.setAddress(person.getAddress());
            return dao.save(personBd);
        }).orElse(null);
    }

    @Override
    public Person updateEmailAddress(Person person) {
        return dao.findById(person.getId()).map(personBd -> {
            personBd.setEmailAddress(person.getEmailAddress());
            return dao.save(personBd);
        }).orElse(null);
    }


    @Override
    public boolean delete(String id) {
        Optional<Person> personToDelete = dao.findById(id);
        if (personToDelete.isPresent()) {
            dao.delete(personToDelete.get());
            return true;
        }
        return false;
    }
}
