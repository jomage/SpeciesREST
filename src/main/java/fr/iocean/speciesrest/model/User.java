package fr.iocean.speciesrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entité représentant un utilisateur de notre application, avec un login et un mot de passe
 * et un role (Authority).
 *
 * Dans notre cas, un user possède un et un seul Authority (contrairement à Spring Security
 * qui prévoit une liste d'Authority par défaut)
 */
@Entity
@Table(name = "user_") // nécéssaire car la table "user" est déjà présente dans certains SGBD
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore // sécurité : pour ne pas montrer le mot de passe quand on va chercher l'utilisateur
    @NotNull
    @Size(min = 60, max = 60) // le hash BCrypt par défaut donne des strings de 60 chars
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @ManyToOne
    private Authority authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
