package fr.iocean.speciesrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Entité représentant une Authority au sens Spring Security.
 * Par défaut il y en a 2 : ROLE_ADMIN et ROLE_USER (ont été ajoutés à la main dans la base).
 */
@Entity
public class Authority {

    @NotNull
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
