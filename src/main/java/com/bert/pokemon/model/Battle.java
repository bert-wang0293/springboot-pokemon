package com.bert.pokemon.model;

public class Battle {
    private Integer battle_id;
    private Integer trainer1_id;
    private Integer trainer2_id;
    private String battle_result;

    public Integer getBattle_id() {
        return battle_id;
    }

    public void setBattle_id(Integer battle_id) {
        this.battle_id = battle_id;
    }

    public Integer getTrainer1_id() {
        return trainer1_id;
    }

    public void setTrainer1_id(Integer trainer1_id) {
        this.trainer1_id = trainer1_id;
    }

    public Integer getTrainer2_id() {
        return trainer2_id;
    }

    public void setTrainer2_id(Integer trainer2_id) {
        this.trainer2_id = trainer2_id;
    }

    public String getBattle_result() {
        return battle_result;
    }

    public void setBattle_result(String battle_result) {
        this.battle_result = battle_result;
    }
}
