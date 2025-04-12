package com.victor_pokemon.aula.services;


import com.victor_pokemon.aula.domains.Pokemon;
import com.victor_pokemon.aula.domains.enums.NiveisPokemon;
import com.victor_pokemon.aula.domains.enums.TipoPokemon;
import com.victor_pokemon.aula.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class DBService {

    @Autowired
    //@Autowired em vez de criar um novo objeto ele é usado pra trazer um pronto
    private PokemonRepository pokeRepo;

    public void initDB(){

        Pokemon pokemon01 = new Pokemon(null, "Pikachu", TipoPokemon.ELETRICO, NiveisPokemon.INICIANTE, 10, 10, 7,7, LocalDate.now(),"123456");
        Pokemon pokemon02 = new Pokemon(null, "Charmander", TipoPokemon.FOGO, NiveisPokemon.AVANCADO, 19, 25, 10,6, LocalDate.now(),"654321");

        pokeRepo.save(pokemon01);
        pokeRepo.save(pokemon02);

    }




}
