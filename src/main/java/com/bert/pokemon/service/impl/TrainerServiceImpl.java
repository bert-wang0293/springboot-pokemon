package com.bert.pokemon.service.impl;

import com.bert.pokemon.dao.TrainerDao;
import com.bert.pokemon.model.Trainer;
import com.bert.pokemon.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TrainerServiceImpl  implements TrainerService {
    @Autowired
    private TrainerDao trainerDao;

    @Override
    //public List<Trainer> getGoodTrainers(Integer badges, String trainer_rank, Integer win_rate) {
    public List<Trainer> getGoodTrainers(Trainer trainer) {
        return trainerDao.getGoodTrainers(trainer);
    }

    @Override
    public Map<String, Trainer> getTrainersWinRateByBattleId(Integer battle_id) {
        return trainerDao.getTrainersWinRateByBattleId(battle_id);
    }
}
