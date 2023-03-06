package linkedrh.com.api.dao;

import linkedrh.com.api.entity.Funcionario;
import linkedrh.com.api.entity.TurmaParticipante;

import java.util.List;

public interface ParticipanteDao {
    public void excluirParticipante(int idTurma, int idFuncionario);
    int adicionarParticipante(TurmaParticipante turmaParticipante);
    public List<Funcionario> listarParticipantes(int idTurma);
}
