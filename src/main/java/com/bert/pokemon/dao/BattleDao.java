package com.bert.pokemon.dao;

import com.bert.pokemon.model.Battle;

import java.util.List;

public interface BattleDao {
    List<Battle> getBattlesByTrainerId(Integer trainer_id);
}
