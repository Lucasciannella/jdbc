package linkedrh.com.api.mapper;

import linkedrh.com.api.entity.Funcionario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioMapper implements RowMapper<Funcionario>{


    @Override
    public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(rs.getInt("codigo"));
        funcionario.setNome(rs.getString("nome"));
        funcionario.setCpf(rs.getString("cpf"));
        funcionario.setNascimento(rs.getDate("nascimento"));
        funcionario.setCargo(rs.getString("cargo"));
        funcionario.setAdmissao(rs.getDate("admissao"));
        funcionario.setStatus(rs.getBoolean("status"));
        return funcionario;
    }
}
