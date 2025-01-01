package com.bert.pokemon.dao.impl;

import com.bert.pokemon.dao.BattleDao;
import com.bert.pokemon.model.Battle;
import com.bert.pokemon.rowmapper.BattleRowMapper;
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
        String sql = "select battle_id, trainer1_id, trainer2_id, battle_result " +
                "from battle " +
                "where trainer1_id = :trainer_id or trainer2_id = :trainer_id " +
                "limit 10";

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
