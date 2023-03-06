package linkedrh.com.api.dao;

import linkedrh.com.api.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoDao {
    List<Curso> listarTodos();

    int salvar(Curso curso);

    int deletar(int id);

    int atualizar(Curso curso);

    Optional<Curso> buscarCursoPorId(int id);
}