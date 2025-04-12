package com.victor_pokemon.aula.domains.enums;

public enum TipoPokemon {

    AGUA(0,"ÁGUA"), DRAGAO(1,"DRAGÃO"), ELETRICO(2,"ELÉTRICO"), FADA(3,"FADA"), FANTASMA(4,"FANSTASMA"), FOGO(5,"FOGO")
   ,GELO(6,"GELO"), INSETO(7,"INSETO"), LUTADOR(8,"LUTADOR"), NORMAL(9,"NORMAL"), PEDRA(10,"PEDRA"), PLANTA(11,"PLANTA")
   ,PSIQUICO(12,"PSIQUICO"), SOMBRIO(13,"SOMBRIO"), TERRESTRE(14,"TERRESTRE"), VENENOSO(15,"VENENOSO"), VOADOR(16,"VOADOR");

    private int id;
    private String tipoPokemon;

    TipoPokemon(int id, String tipoPokemon) {
        this.id = id;
        this.tipoPokemon = tipoPokemon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(String tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }


    public static TipoPokemon toEnum(Integer id){
        if(id == null) return null;
        for( TipoPokemon x : TipoPokemon.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo inválido");
    }
}
