package com.victor_pokemon.aula.domains.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.victor_pokemon.aula.domains.Pokemon;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PokemonDTO {

    private Long id ;

    /* utilização do int e integer

    Integer é um objeto que pode ser null.
    int é um primitivo que nunca pode ser null (se você não definir nada, ele vira 0).

O Spring e o Java sabem como converter um no outro:
    Integer → int: o Java pega o valor dentro do objeto (unboxing).
    int → Integer: o Java "empacota" o valor (autoboxing).
    */

    /* Utilização do @NotNull e @NotBlank
    @NotNull	O valor não pode ser null
    @NotBlank	O valor não pode ser null, vazio, ou só espaços em branco

    Então, se você já usa @NotBlank, não precisa de @NotNull, porque o @NotBlank já verifica isso e mais um pouco




    @Min(1)	O valor deve ser ≥ 1
    @Positive	O valor deve ser > 0
    @PositiveOrZero	O valor deve ser ≥ 0


    */

    @NotNull(message = "O campo nomePokemon não pode ser nulo")
    @NotBlank(message = "O campo nomePokemon não pode ser vazio")
    private String nomePokemon;

    private int tipoPokemon;
    private int niveisPokemon;

    //@Positive é usada para validar se um número é estritamente maior que zero.
    @Positive(message = "O valor deve ser maior que zero")
    private int pontosDeVida;
    @Positive(message = "O valor deve ser maior que zero")
    private int ataque;
    @Positive(message = "O valor deve ser maior que zero")
    private int defesa;
    @Positive(message = "O valor deve ser maior que zero")
    private int velocidade;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCaptura = LocalDate.now();


    @NotNull(message = "O campo  cpfPokemon não pode ser nulo")
    @NotBlank(message = "O campo cpfPokemon não pode ser vazio")
    private String cpfPokemon;


    public PokemonDTO() {
    }

    public PokemonDTO(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.nomePokemon = pokemon.getNomePokemon();
        this.tipoPokemon = pokemon.getTipoPokemon().getId();
        this.niveisPokemon = pokemon.getNiveisPokemon().getId();
        this.pontosDeVida = pokemon.getPontosDeVida();
        this.ataque = pokemon.getAtaque();
        this.defesa = pokemon.getDefesa();
        this.velocidade = pokemon.getVelocidade();
        this.dataCaptura = pokemon.getDataCaptura();
        this.cpfPokemon = pokemon.getCpfPokemon();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(@NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public int getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(int tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public int getNiveisPokemon() {
        return niveisPokemon;
    }

    public void setNiveisPokemon(int niveisPokemon) {
        this.niveisPokemon = niveisPokemon;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public LocalDate getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(LocalDate dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public @NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String getCpfPokemon() {
        return cpfPokemon;
    }

    public void setCpfPokemon(@NotNull(message = "O campo nomePokemon não pode ser nulo") @NotBlank(message = "O campo nomePokemon não pode ser vazio") String cpfPokemon) {
        this.cpfPokemon = cpfPokemon;
    }
}
