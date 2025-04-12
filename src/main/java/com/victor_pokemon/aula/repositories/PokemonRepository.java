package com.victor_pokemon.aula.repositories;


import com.victor_pokemon.aula.domains.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PokemonRepository extends JpaRepository<Pokemon, Long> {

    //È usado para consultar o banco de dados e buscar um Pokémon com base no valor do CPF do Pokémon
    Optional<Pokemon> findByCpfPokemon(String cpfPokemon);

}
