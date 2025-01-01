package com.bert.pokemon.rowmapper;

import com.bert.pokemon.model.Battle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BattleRowMapper implements RowMapper<Battle> {

    @Override
    public Battle mapRow(ResultSet rs, int rowNum) throws SQLException {
        Battle battle = new Battle();
        battle.setBattle_id(rs.getInt("battle_id"));
        battle.setTrainer1_id(rs.getInt("trainer1_id"));
        battle.setTrainer2_id(rs.getInt("trainer2_id"));
        battle.setBattle_result(rs.getString("battle_result"));
        return battle;
    }
}
