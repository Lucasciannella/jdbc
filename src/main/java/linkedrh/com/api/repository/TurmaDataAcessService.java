package linkedrh.com.api.repository;

import linkedrh.com.api.dao.TurmaDao;
import linkedrh.com.api.entity.Turma;
import linkedrh.com.api.mapper.TurmaComQuantidadeDeFuncionariosMapper;
import linkedrh.com.api.mapper.TurmaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaDataAcessService implements TurmaDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int salvar(Turma turma) {
        var sql = """
                INSERT INTO TURMA (inicio, fim, local, codigo_curso) VALUES (?, ?, ?, ?)
                """;
        return jdbcTemplate.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCodigoCurso());

    }

    @Override
    public int atualizar(Turma turma) {
        var sql = """
                UPDATE TURMA SET inicio=?, fim=?,local=? WHERE codigo = ?
                """;
        return jdbcTemplate.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCodigo());

    }

    @Override
    public void excluir(int id) {
        var sql = """
                DELETE FROM TURMA WHERE codigo = ?
                """;
        jdbcTemplate.update(sql, id);
    }


    @Override
    public List<Turma> buscarPorCurso(int idCurso) {
        var sql = """ 
                SELECT t.codigo,t.inicio,t.fim,t.local,t.codigo_curso,COUNT(tp.codigo_funcionario) as quantidade_funcionarios 
                FROM TURMA t
                LEFT JOIN TURMA_PARTICIPANTE tp ON t.codigo = tp.codigo_turma
                WHERE t.codigo_curso = ?
                GROUP BY t.codigo, t.inicio, t.fim, t.local, t.codigo_curso
                ORDER BY t.inicio, t.fim
                 """;
        return jdbcTemplate.query(sql, new Object[]{idCurso}, new TurmaComQuantidadeDeFuncionariosMapper());
    }

    @Override
    public Optional<Turma> buscarCursoPorId(int id) {
        var sql = """
                SELECT codigo,inicio,fim,local
                FROM TURMA
                WHERE codigo = ?
                """;
        return jdbcTemplate.query(sql, new TurmaMapper(), id)
                .stream()
                .findFirst();
    }
}