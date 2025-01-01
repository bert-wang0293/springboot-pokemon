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
        String sql = "select trainer_id, name, badges, trainer_rank, win_rate " +
                "from trainer " +
                "where badges >= :badges " +
                "and trainer_rank = :trainer_rank " +
                "and win_rate > :win_rate " +
                "and trainer_id in (" +
                "  select trainer_id " +
                "  from pokemon " +
                "  group by trainer_id " +
                "  having count(trainer_id) > 3" +
                ") " +
                "limit 5";

        Map<String, Object> map = new HashMap<>();
        map.put("badges", trainer.getBadges());
        map.put("trainer_rank", trainer.getTrainer_rank());
        map.put("win_rate", trainer.getWin_rate());

        List<Trainer> trainerList = namedParameterJdbcTemplate.query(sql, map, new TrainerRowMapper());
        return trainerList;
    }

    @Override
    public Map<String, Trainer> getTrainersWinRateByBattleId(Integer battle_id) {
        String sql = "select " +
                "t1.name as Trainer1Name, t1.badges as Trainer1Badges, " +
                "t1.trainer_rank as Trainer1Rank, t1.win_rate as Trainer1WinRate, " +
                "t2.name as Trainer2Name, t2.badges as Trainer2Badges, " +
                "t2.trainer_rank as Trainer2Rank, t2.win_rate as Trainer2WinRate " +
                "from battle b " +
                "join trainer t1 on b.trainer1_id = t1.trainer_id " +
                "join trainer t2 on b.trainer2_id = t2.trainer_id " +
                "where b.battle_id = :battleId";

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