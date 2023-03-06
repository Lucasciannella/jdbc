package linkedrh.com.api.service;

import linkedrh.com.api.dao.TurmaDao;
import linkedrh.com.api.dto.TurmaPostDto;
import linkedrh.com.api.dto.TurmaPutDto;
import linkedrh.com.api.entity.Turma;
import linkedrh.com.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaDao turmaDao;

    public TurmaPostDto salvar(TurmaPostDto turmaPostDto) {
        var result = turmaDao.salvar(turmaPostDto);
        if (result != 1) {
            throw new IllegalStateException("Não Foi possível salvar o Curso");
        }
        return turmaPostDto;
    }

    public void deletar(int id) {
        turmaDao.excluir(id);
    }

    public TurmaPutDto atualizar(TurmaPutDto turmaPutDto) {
        var turmas = turmaDao.buscarCursoPorId(turmaPutDto.getCodigo());
        turmas.ifPresentOrElse(curso1 -> {
                    var result = turmaDao.atualizar(turmaPutDto);
                    if (result != 1) {
                        throw new IllegalStateException("Não foi possível deletar o curso");
                    }
                }, () -> {
                    throw new NotFoundException(String.format("Turma com o id %s não encontrado", turmaPutDto.getCodigo()));
                }
        );
        return turmaPutDto;
    }

    public List<Turma> buscarTurmaPorCurso(int id) {
        return turmaDao.buscarPorCurso(id);
    }
}