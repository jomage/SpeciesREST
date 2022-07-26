package fr.iocean.speciesrest.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCrypt extends BCryptPasswordEncoder {

}
