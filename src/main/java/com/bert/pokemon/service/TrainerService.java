package com.bert.pokemon.service;

import com.bert.pokemon.model.Trainer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface TrainerService {
    //List<Trainer> getGoodTrainers(Integer badges, String trainer_rank, Integer win_rate);
    List<Trainer> getGoodTrainers(Trainer trainer);
    Map<String, Trainer> getTrainersWinRateByBattleId(Integer battle_id);
}
