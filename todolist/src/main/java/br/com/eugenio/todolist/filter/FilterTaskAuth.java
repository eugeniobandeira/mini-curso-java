package br.com.eugenio.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Essa anotação diz para o spring gerenciar a classe
@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException 
            {
                //Pegar a autenticação (usuário e senha)
                var authorization = request.getHeader("Authorization");
                var authEncoded = authorization.substring("Basic".length()).trim();
                byte[] authDecode = Base64.getDecoder().decode(authEncoded);
                var authString = new String(authDecode);

                System.out.println(authString);

                String[] credentials = authString.split(":");
                String username = credentials[0];
                String password = credentials[1];

                System.out.println(username);
                System.out.println(password);
                //Validar usuário

                //Segue viagem
                filterChain.doFilter(request, response);
            }

    
    
}
