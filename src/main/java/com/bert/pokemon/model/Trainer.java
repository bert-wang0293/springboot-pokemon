package com.bert.pokemon.model;

public class Trainer {
    private Integer trainer_id;
    private String name;
    private Integer badges;
    private String trainer_rank;
    private Integer win_rate;

    public Integer getTrainer_id() {
        return trainer_id;
    }
    public void setTrainer_id(Integer trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getBadges() {
        return badges;
    }
    public void setBadges(Integer badges) {
        this.badges = badges;
    }

    public String getTrainer_rank() {
        return trainer_rank;
    }
    public void setTrainer_rank(String trainer_rank) {
        this.trainer_rank = trainer_rank;
    }

    public Integer getWin_rate() {
        return win_rate;
    }
    public void setWin_rate(Integer win_rate) {
        this.win_rate = win_rate;
    }
}
