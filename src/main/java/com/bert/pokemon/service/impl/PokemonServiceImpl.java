package com.bert.pokemon.service.impl;

import com.bert.pokemon.dao.PokemonDao;
import com.bert.pokemon.model.Pokemon;
import com.bert.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonDao pokemonDao;

    @Override
    public List<Pokemon> getPokemonsByCP(Integer trainer_id) {
        return pokemonDao.getPokemonsByCP(trainer_id);
    }

    @Override
    public List<Pokemon> getPokemonsByWeakness(Pokemon pokemon) {
        return pokemonDao.getPokemonsByWeakness(pokemon);
    }

    @Override
    public List<Pokemon> getPokemonsByFamilyName(Pokemon pokemon) {
        return pokemonDao.getPokemonsByFamilyName(pokemon);
    }
}
