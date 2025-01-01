package com.bert.pokemon.service;

import com.bert.pokemon.model.Battle;

import java.util.List;

public interface BattleService {
    List<Battle> getBattlesByTrainerId(Integer trainer_id);
}
