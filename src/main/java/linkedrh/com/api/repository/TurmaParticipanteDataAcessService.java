package linkedrh.com.api.repository;

import linkedrh.com.api.dao.TurmaParticipanteDao;
import linkedrh.com.api.dto.TurmaParticipanteDto;
import linkedrh.com.api.entity.Funcionario;
import linkedrh.com.api.mapper.FuncionarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TurmaParticipanteDataAcessService implements TurmaParticipanteDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void excluirParticipante(int idTurma, int idFuncionario) {
        var sql = "DELETE FROM TURMA_PARTICIPANTE WHERE codigo_turma = ? AND codigo_funcionario = ?";

        jdbcTemplate.update(sql, idTurma, idFuncionario);
    }

    @Override
    public int adicionarParticipante(TurmaParticipanteDto turmaParticipanteDto) {
        var sql = """
                INSERT INTO TURMA_PARTICIPANTE (codigo_turma, codigo_funcionario) VALUES(?,?)
                """;
        return jdbcTemplate.update(sql, turmaParticipanteDto.getCodigoTurma(), turmaParticipanteDto.getCodigoFuncionario());
    }

    @Override
    public List<Funcionario> listarParticipantes(int idTurma) {
        var sql = """
                SELECT f.codigo, f.nome, f.CPF, f.nascimento, f.cargo, f.admissao, f.status
                FROM FUNCIONARIO f
                INNER JOIN TURMA_PARTICIPANTE tp ON f.codigo = tp.codigo_funcionario
                WHERE tp.codigo_turma = ?        
                """;

        return jdbcTemplate.query(sql, new Object[]{idTurma}, new FuncionarioMapper());
    }
}