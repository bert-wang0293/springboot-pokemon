package com.bert.pokemon.dao;

import com.bert.pokemon.model.Trainer;

import java.util.List;
import java.util.Map;

public interface TrainerDao {
    //List<Trainer> getGoodTrainers(Integer badges, String trainer_rank, Integer win_rate);
    List<Trainer> getGoodTrainers(Trainer trainer);
    Map<String, Trainer> getTrainersWinRateByBattleId(Integer battle_id);
}
