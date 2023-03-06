package linkedrh.com.api.dao;

import linkedrh.com.api.dto.TurmaParticipanteDto;
import linkedrh.com.api.entity.Funcionario;

import java.util.List;

public interface TurmaParticipanteDao {
    public void excluirParticipante(int idTurma, int idFuncionario);
    int adicionarParticipante(TurmaParticipanteDto turmaParticipanteDto);
    public List<Funcionario> listarParticipantes(int idTurma);
}
