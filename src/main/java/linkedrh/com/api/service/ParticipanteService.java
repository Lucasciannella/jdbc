package linkedrh.com.api.service;

import linkedrh.com.api.dao.ParticipanteDao;
import linkedrh.com.api.entity.Funcionario;
import linkedrh.com.api.entity.TurmaParticipante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipanteService {

    private final ParticipanteDao participanteDao;

    public TurmaParticipante adicionarParticipante(TurmaParticipante turmaParticipante) {
        var result = participanteDao.adicionarParticipante(turmaParticipante);
        if (result != 1) {
            throw new IllegalStateException("Não foi possível adicionar participante a turma");
        }
        return turmaParticipante;
    }

    public List<Funcionario> listarParticipantes(int idTurma) {
        return participanteDao.listarParticipantes(idTurma);
    }

    public void excluirParticipantes(int idTurma, int idFuncionario) {
        participanteDao.excluirParticipante(idTurma, idFuncionario);
    }
}
