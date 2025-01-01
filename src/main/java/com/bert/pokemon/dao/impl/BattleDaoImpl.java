package com.bert.pokemon.dao.impl;

import com.bert.pokemon.dao.BattleDao;
import com.bert.pokemon.model.Battle;
import com.bert.pokemon.model.Pokemon;
import com.bert.pokemon.rowmapper.BattleRowMapper;
import com.bert.pokemon.rowmapper.PokemonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BattleDaoImpl implements BattleDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Battle> getBattlesByTrainerId(Integer trainer_id) {
        String sql = "SELECT battle_id, trainer1_id, trainer2_id, battle_result " +
                "FROM battle " +
                "WHERE trainer1_id = :trainer_id OR trainer2_id = :trainer_id " +
                "LIMIT 10";

        Map<String, Object> map = new HashMap<>();
        map.put("trainer_id", trainer_id);
        List<Battle> list = namedParameterJdbcTemplate.query(sql, map, new BattleRowMapper());

        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
