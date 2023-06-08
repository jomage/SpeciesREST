package fr.iocean.speciesrest.repository;

import fr.iocean.speciesrest.model.Person;

import java.util.List;

public interface PersonRepositoryCustom {

    int deletePersonsWithoutAnimal();

    int deletePersonsWithoutAnimal2();

    void insertRandomPersons(int numberToCreate);

    List<Person> testCriterias(String firstname, String lastname, Integer age);

    void insertRandomPersonsFaker(int numberToCreate);
}
