package linkedrh.com.api.dao;

import linkedrh.com.api.entity.Turma;

import java.util.List;

public interface TurmaDao {
    public int salvar(Turma turma);
    public Turma atualizar(Turma turma);
    public void excluir(int id);
    public List<Turma> buscarPorCurso(int idCurso);
}
