package com.bert.pokemon.dao.impl;

import com.bert.pokemon.dao.PokemonDao;
import com.bert.pokemon.model.Pokemon;
import com.bert.pokemon.rowmapper.PokemonRowMapper;
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
        String sql = "select birth_number, pokemon_name, family_name, " +
                "family_number, cp, type, weakness, trainer_id " +
                "from pokemon " +
                "where trainer_id = :trainer_id " +
                "order by cp desc " +
                "limit 1";

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
        String sql = "select birth_number, pokemon_name, family_name, " +
                "family_number, cp, type, weakness, trainer_id " +
                "from pokemon " +
                "where type = :type and cp > :cp " +
                "limit 10";

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
        String sql = "select birth_number, pokemon_name, family_name, " +
                "family_number, cp, type, weakness, trainer_id " +
                "from pokemon " +
                "where family_name = :family_name " +
                "order by family_number " +
                "limit 10";

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
