package linkedrh.com.api.dao;

import linkedrh.com.api.dto.CursoPostDto;
import linkedrh.com.api.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoDao {
    List<Curso> listarTodos();

    int salvar(CursoPostDto cursoPostDto);

    int deletar(int id);

    int atualizar(Curso curso);

    Optional<Curso> buscarCursoPorId(int id);
}