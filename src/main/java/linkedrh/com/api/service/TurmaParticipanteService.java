package linkedrh.com.api.service;

import linkedrh.com.api.dao.TurmaParticipanteDao;
import linkedrh.com.api.dto.TurmaParticipanteDto;
import linkedrh.com.api.entity.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaParticipanteService {

    private final TurmaParticipanteDao turmaParticipanteDao;

    public TurmaParticipanteDto adicionarParticipante(TurmaParticipanteDto turmaParticipanteDto) {
        var result = turmaParticipanteDao.adicionarParticipante(turmaParticipanteDto);
        if (result != 1) {
            throw new IllegalStateException("Não foi possível adicionar participante a turma");
        }
        return turmaParticipanteDto;
    }

    public List<Funcionario> listarParticipantes(int idTurma) {
        return turmaParticipanteDao.listarParticipantes(idTurma);
    }

    public void excluirParticipantes(int idTurma, int idFuncionario) {
        turmaParticipanteDao.excluirParticipante(idTurma, idFuncionario);
    }
}
