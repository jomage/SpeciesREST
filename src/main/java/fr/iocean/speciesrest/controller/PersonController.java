package fr.iocean.speciesrest.controller;

import fr.iocean.speciesrest.model.Person;
import fr.iocean.speciesrest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String trucAdmin() {
        return "Personnes administrées.";
    }

    /**
     * A pour but de lancer une exception (test de l'aspect)
     */
    @GetMapping("/savenull")
    public void bidon() {
        this.personService.create(null);
    }

    @GetMapping("/gettest")
    public void bidon2() {
        this.personService.getNull();
    }

    @GetMapping
    public Page<Person> findAll(Pageable pageable) {
        return this.personService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable("id") Integer id) {
        return this.personService.findById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody @Valid Person personToCreate) {
        return this.personService.create(personToCreate);
    }

    @PutMapping
    public Person updatePerson(@RequestBody @Valid Person updatedPerson) {
        return this.personService.update(updatedPerson);
    }

}
