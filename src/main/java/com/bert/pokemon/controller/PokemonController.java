package com.bert.pokemon.controller;

import com.bert.pokemon.model.Pokemon;
import com.bert.pokemon.model.Trainer;
import com.bert.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    //查詢對手的王牌寶可夢
    @GetMapping("/pokemons/{trainer_id}")
    public List<Pokemon> getPokemonsByCP(@PathVariable Integer trainer_id) {
        List<Pokemon> list = pokemonService.getPokemonsByCP(trainer_id);
        return list;
    }

    //查詢能夠克制的野生寶可夢
    @PostMapping("/pokemons")
    public List<Pokemon> getPokemonsByWeakness(@RequestBody Pokemon pokemon) {
        List<Pokemon> list = pokemonService.getPokemonsByWeakness(pokemon);
        return list;
    }

    @PostMapping("/pokemonFamily")
    public List<Pokemon> getPokemonsByFamilyName(@RequestBody Pokemon pokemon) {
        System.out.println("Family_name : " + pokemon.getFamily_name());
        List<Pokemon> list = pokemonService.getPokemonsByFamilyName(pokemon);
        return list;
    }
}
