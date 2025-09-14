package com.victor_pokemon.aula.domains.enums;



public enum NiveisPokemon {

    //Niveis de Pokemon
    INICIANTE(0,"INICIANTE"), INTERMEDIARIO(1,"INTERMEDIARIO"), AVANCADO(2,"AVANÇADO"), LENDARIO(3,"LENDARIO");

    private int id;
    private String niveisPokemon;




    NiveisPokemon(int id, String niveisPokemon) {
        this.id = id;
        this.niveisPokemon = niveisPokemon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNiveisPokemon() {
        return niveisPokemon;
    }

    public void setNiveisPokemon(String niveisPokemon) {
        this.niveisPokemon = niveisPokemon;
    }


    //Esse metodo statico faz com que o enum não precise de uma  instancia.

    /*Ele pegas os enums e transforma em id ,  quando voce for utilizar o enum voce
     informa apenas o id e ele tras a descrição do número, caso não seja um id valido
     ele retorna a mensagem de id invalido
     */

    public static NiveisPokemon toEnum(Integer id){
            if(id == null) return null;
            for( NiveisPokemon x : NiveisPokemon.values()){
                if(id.equals(x.getId())){
            return x;
        }
    }
            throw new IllegalArgumentException("Nivél inválido");

    }
}
