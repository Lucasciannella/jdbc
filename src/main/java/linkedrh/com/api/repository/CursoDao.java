package linkedrh.com.api.repository;

import linkedrh.com.api.dto.Curso;
import java.util.Optional;

import java.util.List;

public interface CursoDao {
    List<Curso> listarTodos();

    int salvar(Curso curso);

    int deletar(int id);

    int atualizar(Curso curso);

    Optional<Curso> buscarCursoPorId(int id);
}