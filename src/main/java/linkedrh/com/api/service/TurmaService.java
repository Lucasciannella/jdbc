package linkedrh.com.api.service;

import linkedrh.com.api.dao.TurmaDao;
import linkedrh.com.api.entity.Turma;
import linkedrh.com.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaDao turmaDao;

    public Turma salvar(Turma turma) {
        var result = turmaDao.salvar(turma);
        if (result != 1) {
            throw new IllegalStateException("Não Foi possível salvar o Curso");
        }
        return turma;
    }

    public void deletar(int id) {
        turmaDao.excluir(id);
    }

    public Turma atualizar(Turma turma) {
        var turmas = turmaDao.buscarCursoPorId(turma.getCodigo());
        turmas.ifPresentOrElse(curso1 -> {
                    var result = turmaDao.atualizar(turma);
                    if (result != 1) {
                        throw new IllegalStateException("Não foi possível deletar o curso");
                    }
                }, () -> {
                    throw new NotFoundException(String.format("Turma com o id %s não encontrado", turma.getCodigo()));
                }
        );
        return turma;
    }

    public List<Turma> buscarTurmaPorCurso(int id) {
        return turmaDao.buscarPorCurso(id);
    }
}