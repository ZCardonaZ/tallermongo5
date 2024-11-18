package com.example.MongoTaller5.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.MongoTaller5.Models.Person;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepositoryImpl extends MongoRepository<Person, String> {


}
