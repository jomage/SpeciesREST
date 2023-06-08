package fr.iocean.speciesrest.service;

import fr.iocean.speciesrest.model.User;
import fr.iocean.speciesrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémente l'interface UserDetailsService de Spring, nécéssaire à Spring Security
 * pour authentifier l'utilisateur depuis la BDD.
 *
 * C'est cette classe qui va "faire le lien" entre nos tables User / Authorithy et
 * Spring Security.
 */
@Component
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Crée et retourne un UserDetails (Spring Security) à partir de nos tables User/Authority.
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return createSpringSecurityUser(this.userRepository.findFirstByLogin(username));
    }

    /**
     * Convertit un User (notre table) en User Spring Security.
     */
    private org.springframework.security.core.userdetails.User createSpringSecurityUser(User myUser) {
        // Récupération du ROLE + on le met dans une liste (le user Spring requiert une liste)
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(myUser.getAuthority().getName()));

        return new org.springframework.security.core.userdetails.User(
                myUser.getLogin(),
                myUser.getPassword(),
                grantedAuthorities);
    }
}
