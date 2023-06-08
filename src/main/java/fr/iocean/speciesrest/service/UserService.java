package fr.iocean.speciesrest.service;

import fr.iocean.speciesrest.model.User;
import fr.iocean.speciesrest.repository.AuthorityRepository;
import fr.iocean.speciesrest.repository.UserRepository;
import fr.iocean.speciesrest.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    BCrypt crypt;

    /**
     * Crée et enregistre un user avec le login et mdp donné et role
     * "USER".
     * @param login le login de l'utilisateur
     * @param mdp le mot de passe dont la version encodée sera sauvegardée
     *           en base
     * @return l'utilisateur créé
     */
    public User createUser(String login, String mdp) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(crypt.encode(mdp));
        user.setAuthority(authorityRepository.findById("ROLE_USER").orElse(null));
        return userRepository.save(user);
    }
}
