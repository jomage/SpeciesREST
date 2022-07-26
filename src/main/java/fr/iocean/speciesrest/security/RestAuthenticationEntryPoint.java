package fr.iocean.speciesrest.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {

        response.sendError(
                // On peut changer ici le status code si on veut voir ce que ca change
                // comme par exemple HttpServletResponse.SC_FORBIDDEN
                HttpServletResponse.SC_UNAUTHORIZED,
                "Pas-autorise-du-tout-du-tout");

    }
}
