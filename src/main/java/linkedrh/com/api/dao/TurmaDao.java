package linkedrh.com.api.dao;

import linkedrh.com.api.entity.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaDao {
    public int salvar(Turma turma);

    public int atualizar(Turma turma);

    public void excluir(int id);

    public List<Turma> buscarPorCurso(int idCurso);

    Optional<Turma> buscarCursoPorId(int id);
}