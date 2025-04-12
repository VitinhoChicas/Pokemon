package com.victor_pokemon.aula.resources;


import com.victor_pokemon.aula.domains.Pokemon;
import com.victor_pokemon.aula.domains.dtos.PokemonDTO;
import com.victor_pokemon.aula.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//Marca uma classe como controller de uma API REST
//Tudo que é retornado pelos metodos @RestController será enviado diretamente no corpo da resposta (em JSON, por padrão)

@RequestMapping(value = "/pokemon")
// Define o caminho da URl que sera Usada para acessar os métodos de um controller
public class PokemonResource {

    @Autowired
    private PokemonService pokeService;


    //Este metodo retorna todos os pokémons em formato DTO com status HTTP 200.
    @GetMapping
    public ResponseEntity<List<PokemonDTO>> findAll(){
        return  ResponseEntity.ok().body(pokeService.findAll());
    }

    //Este metodo faz uma busca pelo id especifico
    @GetMapping(value = "/{id}")
    public ResponseEntity<PokemonDTO> findbyId(@PathVariable Long id){
        Pokemon obj = this.pokeService.findbyId(id);
        return ResponseEntity.ok().body(new PokemonDTO(obj));
    }
    //@PathVariable é usado para extrair o valor do id diretamente da URL da requisição.

    //Este metodo faz uma buscar por cpfpokemon
    @GetMapping(value = "/cpfPokemon/{cpfPokemon}")
    public ResponseEntity<PokemonDTO> findById(@PathVariable String cpfPokemon){
        Pokemon obj = this.pokeService.findbyCpfPokemon(cpfPokemon);
        return ResponseEntity.ok().body(new PokemonDTO(obj));
    }

    //Metodo para a criação de um novo pokemon
    @PostMapping
    public ResponseEntity<PokemonDTO> create(@Valid  @RequestBody PokemonDTO pokemonDTO){
        Pokemon pokemon = pokeService.create(pokemonDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(pokemon.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    //A anotação @Valid é usada no Spring (e outras frameworks Java) para ativar a validação automática dos dados de entrada, com base nas anotações de validação presentes na sua classe — como @NotNull, @NotBlank

    //Metodo para alterar um Pokemon
    @PutMapping(value = "/{id}")
    public ResponseEntity<PokemonDTO> update(@PathVariable Long id, @Valid @RequestBody PokemonDTO objDTO){
        Pokemon Obj = pokeService.update(id, objDTO);
        return  ResponseEntity.ok().body(new PokemonDTO(Obj));
    }

    //Metodo para deletar um Pokemon
    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<PokemonDTO> delete(@PathVariable Long id){
        pokeService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }


}
