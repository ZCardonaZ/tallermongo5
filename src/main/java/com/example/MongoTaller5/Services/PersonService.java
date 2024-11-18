package com.example.MongoTaller5.Services;

import java.util.List;

import com.example.MongoTaller5.Models.Person;

public interface PersonService {

    public List<Person> findAll();

    public List<Person> findAllConNombreUpperCase();

    public List<Person> findAllConNombreUpperCaseRepeat();

    public Person findById(String id);

    public Person save(Person person);

    public boolean delete(String person);

    public Person updateCellNumber(Person person);

    public Person updateAddress(Person person);

    public Person updateEmailAddress(Person person);


}
