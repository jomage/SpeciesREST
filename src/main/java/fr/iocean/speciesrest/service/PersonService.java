package fr.iocean.speciesrest.service;

import fr.iocean.speciesrest.model.Person;
import fr.iocean.speciesrest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person create(@Valid Person personToCreate) {
        return this.personRepository.save(personToCreate);
    }

    public Person update(@Valid Person updatedPerson) {
        return this.personRepository.save(updatedPerson);
    }

    public Page<Person> findAll(Pageable pageable) {
        return this.personRepository.findAll(pageable);
    }

    public Person findById(Integer id) {
        return this.personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Person> findByLastnameOrFirstname(String lastname, String firstname) {
        return this.personRepository.findByLastnameOrFirstname(lastname, firstname);
    }

    public List<Person> findByAgeGreaterThanEqual(Integer ageMinimal) {
        return this.personRepository.findByAgeGreaterThanEqual(ageMinimal);
    }

}
