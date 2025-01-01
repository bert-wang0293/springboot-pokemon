package com.bert.pokemon.rowmapper;

import com.bert.pokemon.model.Pokemon;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonRowMapper implements RowMapper<Pokemon> {

    @Override
    public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pokemon pokemon = new Pokemon();
        pokemon.setBirth_number(rs.getInt("birth_number"));
        pokemon.setPokemon_name(rs.getString("pokemon_name"));
        pokemon.setFamily_name(rs.getString("family_name"));
        pokemon.setFamily_number(rs.getInt("family_number"));
        pokemon.setCp(rs.getInt("cp"));
        pokemon.setType(rs.getString("type"));
        pokemon.setWeakness(rs.getString("weakness"));
        pokemon.setTrainer_id(rs.getInt("trainer_id"));
        return pokemon;
    }
}
