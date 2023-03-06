package linkedrh.com.api.mapper;

import linkedrh.com.api.entity.Turma;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TurmaComQuantidadeDeFuncionariosMapper implements RowMapper<Turma> {

    @Override
    public Turma mapRow(ResultSet rs, int rowNum) throws SQLException {
        Turma turma = new Turma();
        turma.setCodigo(rs.getInt("codigo"));
        turma.setInicio(rs.getDate("inicio").toLocalDate());
        turma.setFim(rs.getDate("fim").toLocalDate());
        turma.setLocal(rs.getString("local"));
        turma.setCodigoCurso(rs.getInt("codigo_curso"));
        turma.setQuantidadeFuncionarios(rs.getInt("quantidade_funcionarios"));
        return turma;
    }
}