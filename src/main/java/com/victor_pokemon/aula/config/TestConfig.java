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
    // @PostConstruct: depois que o Spring cria o objeto e injeta todas as dependências, este mtodo é chamado automaticamente para preparar o banco de dados
    public void initDB(){
        this.dbService.initDB();
    }



}
