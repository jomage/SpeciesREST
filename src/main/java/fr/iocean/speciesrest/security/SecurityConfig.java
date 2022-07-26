package fr.iocean.speciesrest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private RestAuthenticationEntryPoint authEntryPoint;

    /**
     * Morceau de code qui va intercepter les requêtes HTTP et les fait passer
     * à travers un "filtre".
     * Ce filtre vérifie si on a bien les droits, si on est authentifié, ...
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // csrf est une protection inutile pour tester en local donc on la désactive.
            .authorizeRequests()
            // si l'url pointe vers /rest/admin, on demande le role "ADMIN" à l'utilisateur.
            .antMatchers("/rest/admin/**").hasRole("ADMIN")
            // pour toutes les requêtes, on demande un utilisateur authentifié.
            .antMatchers("/**").authenticated()
            // on "branche" notre classe pour exécuter l'action en cas de rejet.
            .and()
            .httpBasic().authenticationEntryPoint(authEntryPoint);

        return http.build();
    }

    /**
     * Permet d'ignorer / passer le filtre sur certaines urls, si on le désire.
     * Alternativement, on peut compléter le filtre écrit plus haut pour permettre
     * l'accès à ces urls (avec un antMatchers("...").permitAll par exemple)
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }

/* old - filtre plus simple qui demande juste d'être authentifié.
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .authenticationEntryPoint(authEntryPoint);
    }

*/
}
