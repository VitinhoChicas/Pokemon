package com.victor_pokemon.aula.services;


import com.victor_pokemon.aula.domains.Pokemon;
import com.victor_pokemon.aula.domains.dtos.PokemonDTO;
import com.victor_pokemon.aula.repositories.PokemonRepository;
import com.victor_pokemon.aula.services.exceptions.DataIntegrityViolationException;
import com.victor_pokemon.aula.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokeRepo;

    //Retorna uma Lista de PokemonDTO
    public List<PokemonDTO> findAll(){
        return  pokeRepo.findAll().stream().map(obj -> new PokemonDTO(obj))
                .collect(Collectors.toList());
    }


    //Buscar um Pokemon pelo id , caso não encontrar o id ele retorna null
    public Pokemon findbyId(Long id){
        Optional<Pokemon> obj = pokeRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado Id:" + id));
    }

    //Buscar um Pokemon pelo cpfPokemon , caso não encontrar o id ele retorna null
    public Pokemon findbyCpfPokemon(String cpfPokemon){
        Optional<Pokemon> obj = pokeRepo.findByCpfPokemon(cpfPokemon);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pokemon não encontrado cpfPokemon:" + cpfPokemon));
    }

    //Metodo que cria um novo Pokemon no banco de dados , conforme os dados pela PokemonDTO
    public Pokemon create(PokemonDTO pokemonDTO){
        pokemonDTO.setId(null);
        validaCpf(pokemonDTO);
        Pokemon obj = new Pokemon(pokemonDTO);
        return pokeRepo.save(obj);
    }

    //Metodo para validar  o cpf do pokemon e não deixar duplicidade
    private void validaCpf(PokemonDTO pokemonDTO){
        Optional<Pokemon> obj = pokeRepo.findByCpfPokemon(pokemonDTO.getCpfPokemon());
        if(obj.isPresent() && obj.get().getId() != pokemonDTO.getId()){
    throw  new DataIntegrityViolationException("CpfPokemon ja cadastrado");
        }
    }


    //Metodo para alterar um Pokemon
    public Pokemon update(Long id,  PokemonDTO objDto){
        objDto.setId(id);
        Pokemon oldObj = findbyId(id);
        validaCpf(objDto);
        oldObj = new Pokemon(objDto);
        return pokeRepo.save(oldObj);
    }

    //Metodo para deletar um Pokemon
    public void deletePokemon (Long id){
        Pokemon obj = findbyId(id);
        pokeRepo.deleteById(id);
    }

}
