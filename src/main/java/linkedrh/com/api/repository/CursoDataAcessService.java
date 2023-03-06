package linkedrh.com.api.repository;

import linkedrh.com.api.entity.Curso;
import linkedrh.com.api.mapper.CursoMapper;
import linkedrh.com.api.dao.CursoDao;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CursoDataAcessService implements CursoDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Curso> listarTodos() {
        var sql = """
                SELECT *
                FROM CURSO
                LIMIT 100; 
                """;
        return jdbcTemplate.query(sql, new CursoMapper());
    }

    @Override
    public int salvar(Curso curso) {
        var sql = """
                INSERT INTO CURSO(nome, descricao, duracao)
                VALUES(?,?,?)
                """;
        return jdbcTemplate.update(sql, curso.getNome(), curso.getDescricao(), curso.getDuracao());
    }

    public int atualizar(Curso curso) {
        var sql = """
                UPDATE CURSO SET nome= ?, descricao= ?, duracao = ? WHERE codigo= ?
                """;
        return jdbcTemplate.update(sql, curso.getNome(), curso.getDescricao(), curso.getDuracao(), curso.getCodigo());
    }

    @Override
    public int deletar(int id) {
        var sql = """
                DELETE FROM CURSO
                WHERE codigo = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Curso> buscarCursoPorId(int id) {
        var sql = """
                SELECT codigo,nome, descricao, duracao
                FROM CURSO
                WHERE codigo = ?
                """;
        return jdbcTemplate.query(sql, new CursoMapper(), id)
                .stream()
                .findFirst();
    }
}
