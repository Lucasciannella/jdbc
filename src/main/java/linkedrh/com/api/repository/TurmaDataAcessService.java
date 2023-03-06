package linkedrh.com.api.repository;

import linkedrh.com.api.entity.Turma;
import linkedrh.com.api.mapper.TurmaMapper;
import linkedrh.com.api.dao.TurmaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaDataAcessService implements TurmaDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int salvar(Turma turma) {
        var sql = """
                INSERT INTO TURMA (inicio, fim, local, codigo_curso) VALUES (?, ?, ?, ?)
                """;
        return jdbcTemplate.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCodigo_curso());

    }

    @Override
    public Turma atualizar(Turma turma) {
        var sql = """
                UPDATE TURMA SET inicio=?, fim=?,local=? WHERE codigo = ?
                """;
        jdbcTemplate.update(sql, turma.getInicio(), turma.getFim(), turma.getLocal(), turma.getCodigo());
        return turma;
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
                SELECT *
                FROM TURMA 
                WHERE codigo_curso = ?
                 """;

        return jdbcTemplate.query(sql, new Object[]{idCurso}, new TurmaMapper());
    }
}