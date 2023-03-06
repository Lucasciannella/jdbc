package linkedrh.com.api.repository;

import linkedrh.com.api.entity.Funcionario;
import linkedrh.com.api.entity.TurmaParticipante;
import linkedrh.com.api.mapper.FuncionarioMapper;
import linkedrh.com.api.dao.ParticipanteDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticipanteDataAcessService implements ParticipanteDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void excluirParticipante(int idTurma, int idFuncionario) {
        var sql = "DELETE FROM TURMA_PARTICIPANTE WHERE codigo_turma = ? AND codigo_funcionario = ?";

        jdbcTemplate.update(sql, idTurma, idFuncionario);
    }

    @Override
    public int adicionarParticipante(TurmaParticipante turmaParticipante) {
        var sql = """
                INSERT INTO TURMA_PARTICIPANTE (codigo_turma, codigo_funcionario) VALUES(?,?)
                """;
        return jdbcTemplate.update(sql, turmaParticipante.getCodigo_turma(),turmaParticipante.getCodigo_funcionario());
    }

    @Override
    public List<Funcionario> listarParticipantes(int idTurma) {
        var sql = """
                SELECT f.codigo, f.nome, f.CPF, f.nascimento, f.cargo, f.admissao, f.status
                FROM FUNCIONARIO f
                INNER JOIN TURMA_PARTICIPANTE tp ON f.codigo = tp.codigo_funcionario
                WHERE tp.codigo_turma = ?        
                """;

        return jdbcTemplate.query(sql,new Object[]{idTurma}, new FuncionarioMapper());
    }
}