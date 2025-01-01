package com.bert.pokemon.dao.impl;

import com.bert.pokemon.dao.TrainerDao;
import com.bert.pokemon.model.Trainer;
import com.bert.pokemon.rowmapper.TrainerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TrainerDaoImpl implements TrainerDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    //public List<Trainer> getGoodTrainers(Integer badges, String trainer_rank, Integer win_rate) {
    public List<Trainer> getGoodTrainers(Trainer trainer) {
        String sql = "SELECT trainer_id, name, badges, trainer_rank, win_rate " +
                "FROM trainer " +
                "WHERE badges >= :badges " +
                "AND trainer_rank = :trainer_rank " +
                "AND win_rate > :win_rate " +
                "AND trainer_id IN (" +
                "  SELECT trainer_id " +
                "  FROM pokemon " +
                "  GROUP BY trainer_id " +
                "  HAVING COUNT(trainer_id) > 3" +
                ") " +
                "LIMIT 5";

        Map<String, Object> map = new HashMap<>();
        map.put("badges", trainer.getBadges());
        map.put("trainer_rank", trainer.getTrainer_rank());
        map.put("win_rate", trainer.getWin_rate());

        List<Trainer> trainerList = namedParameterJdbcTemplate.query(sql, map, new TrainerRowMapper());
        return trainerList;
    }

    @Override
    public Map<String, Trainer> getTrainersWinRateByBattleId(Integer battle_id) {
        String sql = "SELECT " +
                "t1.name AS Trainer1Name, t1.badges as Trainer1Badges, " +
                "t1.trainer_rank as Trainer1Rank, t1.win_rate AS Trainer1WinRate, " +
                "t2.name AS Trainer2Name, t2.badges as Trainer2Badges, " +
                "t2.trainer_rank as Trainer2Rank, t2.win_rate AS Trainer2WinRate " +
                "FROM battle b " +
                "JOIN trainer t1 ON b.trainer1_id = t1.trainer_id " +
                "JOIN trainer t2 ON b.trainer2_id = t2.trainer_id " +
                "WHERE b.battle_id = :battleId";

        Map<String, Object> map = new HashMap<>();
        map.put("battleId", battle_id);

        Map<String, Trainer> trainerList = null;
        try {
            trainerList = namedParameterJdbcTemplate.queryForObject(sql, map, (rs, rowNum) -> {

                Trainer trainer1 = new Trainer();
                trainer1.setName(rs.getString("Trainer1Name"));
                trainer1.setBadges(rs.getInt("Trainer1Badges"));
                trainer1.setTrainer_rank(rs.getString("Trainer1Rank"));
                trainer1.setWin_rate(rs.getInt("Trainer1WinRate"));

                Trainer trainer2 = new Trainer();
                trainer2.setName(rs.getString("Trainer2Name"));
                trainer2.setBadges(rs.getInt("Trainer2Badges"));
                trainer2.setTrainer_rank(rs.getString("Trainer2Rank"));
                trainer2.setWin_rate(rs.getInt("Trainer2WinRate"));

                Map<String, Trainer> mapTrainer = new HashMap<>();
                mapTrainer.put("trainer1", trainer1);
                mapTrainer.put("trainer2", trainer2);
                return mapTrainer;
            });
        } catch (EmptyResultDataAccessException e) {
            trainerList = null;
        }
        return trainerList;
    }
}