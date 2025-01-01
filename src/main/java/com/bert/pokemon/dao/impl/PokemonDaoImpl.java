package com.bert.pokemon.dao.impl;

import com.bert.pokemon.dao.PokemonDao;
import com.bert.pokemon.model.Pokemon;
import com.bert.pokemon.model.Trainer;
import com.bert.pokemon.rowmapper.PokemonRowMapper;
import com.bert.pokemon.rowmapper.TrainerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PokemonDaoImpl implements PokemonDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Pokemon> getPokemonsByCP(Integer trainer_id) {
        String sql = "SELECT birth_number, pokemon_name, family_name, " +
                "family_number, cp, type, weakness, trainer_id " +
                "FROM pokemon " +
                "WHERE trainer_id = :trainer_id " +
                "ORDER BY cp DESC " +
                "LIMIT 1";

        Map<String, Object> map = new HashMap<>();
        map.put("trainer_id", trainer_id);
        List<Pokemon> list = namedParameterJdbcTemplate.query(sql, map, new PokemonRowMapper());

        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<Pokemon> getPokemonsByWeakness(Pokemon pokemon) {
        String sql = "SELECT birth_number, pokemon_name, family_name, " +
                "family_number, cp, type, weakness, trainer_id " +
                "FROM pokemon " +
                "WHERE type = :type AND cp > :cp " +
                "LIMIT 10";

        Map<String, Object> map = new HashMap<>();
        map.put("type", pokemon.getWeakness());
        map.put("cp", pokemon.getCp());
        List<Pokemon> list = namedParameterJdbcTemplate.query(sql, map, new PokemonRowMapper());

        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<Pokemon> getPokemonsByFamilyName(Pokemon pokemon) {
        String sql = "SELECT birth_number, pokemon_name, family_name, " +
                "family_number, cp, type, weakness, trainer_id " +
                "FROM pokemon " +
                "WHERE family_name = :family_name " +
                "ORDER BY family_number " +
                "LIMIT 10";

        Map<String, Object> map = new HashMap<>();
        map.put("family_name", pokemon.getFamily_name());
        List<Pokemon> list = namedParameterJdbcTemplate.query(sql, map, new PokemonRowMapper());

        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
