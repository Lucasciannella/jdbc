package linkedrh.com.api.mapper;

import linkedrh.com.api.entity.Curso;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoMapper implements RowMapper<Curso> {

    @Override
    public Curso mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        return new Curso(
                resultSet.getInt("codigo"),
                resultSet.getString("nome"),
                resultSet.getString("descricao"),
                resultSet.getInt("duracao")
        );
    }
}