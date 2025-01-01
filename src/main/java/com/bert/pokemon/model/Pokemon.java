package com.bert.pokemon.model;

public class Pokemon {
    private Integer birth_number;
    private String pokemon_name;
    private String family_name;
    private Integer family_number;
    private Integer cp;
    private String type;
    private String weakness;
    private Integer trainer_id;

    public Integer getBirth_number() {
        return birth_number;
    }

    public void setBirth_number(Integer birth_number) {
        this.birth_number = birth_number;
    }

    public String getPokemon_name() {
        return pokemon_name;
    }

    public void setPokemon_name(String pokemon_name) {
        this.pokemon_name = pokemon_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public Integer getFamily_number() {
        return family_number;
    }

    public void setFamily_number(Integer family_number) {
        this.family_number = family_number;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public Integer getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }
}
