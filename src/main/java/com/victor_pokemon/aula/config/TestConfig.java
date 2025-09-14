package com.victor_pokemon.aula.config;


import com.victor_pokemon.aula.services.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//Define que esta é uma classe de configuração

@Profile("test")
public class TestConfig {


    @Autowired
    private DBService dbService;

    @PostConstruct
    // Esse metodo e executado automaticamente apps a injeção de todas as dependencias, ou seja, depois que o Spring inicializa o objeto.
    //È utilizado aqui para preparar o banco de dados com dados iniciais.
    public void initDB(){
        this.dbService.initDB();
    }



}
