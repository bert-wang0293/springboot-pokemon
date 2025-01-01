package com.bert.pokemon.dao;

import com.bert.pokemon.model.Pokemon;

import java.util.List;

public interface PokemonDao {
    List<Pokemon> getPokemonsByCP(Integer trainer_id);
    List<Pokemon> getPokemonsByWeakness(Pokemon pokemon);
    List<Pokemon> getPokemonsByFamilyName(Pokemon pokemon);
}
