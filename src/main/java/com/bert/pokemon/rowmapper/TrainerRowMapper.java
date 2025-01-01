package com.bert.pokemon.rowmapper;

import com.bert.pokemon.model.Trainer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerRowMapper implements RowMapper<Trainer> {
    @Override
    public Trainer mapRow(ResultSet resultSet, int i) throws SQLException {
        Trainer trainer = new Trainer();
        trainer.setTrainer_id(resultSet.getInt("trainer_id"));
        trainer.setName(resultSet.getString("name"));
        trainer.setBadges(resultSet.getInt("badges"));
        trainer.setTrainer_rank(resultSet.getString("trainer_rank"));
        trainer.setWin_rate(resultSet.getInt("win_rate"));
        return trainer;
    }
}
