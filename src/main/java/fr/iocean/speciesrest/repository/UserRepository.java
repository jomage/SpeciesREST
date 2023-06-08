package fr.iocean.speciesrest.repository;

import fr.iocean.speciesrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository associé aux Users
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Va nous permettre de récupérer un utilisateur par son login.
     */
    User findFirstByLogin(String login);
}
