package com.bert.pokemon.controller;

import com.bert.pokemon.model.Battle;
import com.bert.pokemon.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BattleController {
    @Autowired
    private BattleService battleService;

    @GetMapping("/battles/{trainer_id}")
    public List<Battle> getBattlesByTrainerId(@PathVariable Integer trainer_id) {
        System.out.println("trainer_id : " + trainer_id);
        List<Battle> list = battleService.getBattlesByTrainerId(trainer_id);
        System.out.println("size : " + list.size());
        return list;
    }
}
