package com.bert.pokemon.service.impl;

import com.bert.pokemon.dao.BattleDao;
import com.bert.pokemon.model.Battle;
import com.bert.pokemon.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BattleServiceImpl implements BattleService {
    @Autowired
    private BattleDao battleDao;

    @Override
    public List<Battle> getBattlesByTrainerId(Integer trainer_id) {
        return battleDao.getBattlesByTrainerId(trainer_id);
    }
}
