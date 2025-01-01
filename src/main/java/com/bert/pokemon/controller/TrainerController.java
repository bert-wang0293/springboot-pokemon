package com.bert.pokemon.controller;

import com.bert.pokemon.model.Trainer;
import com.bert.pokemon.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping("/trainers")
    public List<Trainer> getGoodTrainers(@RequestBody Trainer trainer) {
        List<Trainer> trainers = trainerService.getGoodTrainers(trainer);
        return trainers;
    }

    @GetMapping("/trainers/{battle_id}")
    public Map<String, Trainer> getTrainersWinRateByBattleId(@PathVariable Integer battle_id) {
        Map<String, Trainer> list = trainerService.getTrainersWinRateByBattleId(battle_id);
        if (list == null || list.isEmpty()) {
            System.out.println("mapTrainer 為 null 或者為空");
            return null;
        }
        return list;
    }
}
