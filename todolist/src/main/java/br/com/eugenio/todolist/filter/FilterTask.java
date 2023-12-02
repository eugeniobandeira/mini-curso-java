package br.com.eugenio.todolist.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

// Essa anotação diz para o spring gerenciar a classe
@Component
public class FilterTask implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException 
    {
        System.out.println("Cheguei no filtro"); 
        chain.doFilter(request, response);
    }
    
}
