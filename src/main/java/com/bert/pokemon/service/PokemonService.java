package com.bert.pokemon.service;

import com.bert.pokemon.model.Pokemon;
import java.util.List;

public interface PokemonService {
    List<Pokemon> getPokemonsByCP(Integer trainer_id);
    List<Pokemon> getPokemonsByWeakness(Pokemon pokemon);
    List<Pokemon> getPokemonsByFamilyName(Pokemon pokemon);
}
