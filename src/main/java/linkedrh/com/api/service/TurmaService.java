package linkedrh.com.api.service;

import linkedrh.com.api.entity.Turma;
import linkedrh.com.api.dao.TurmaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaDao turmaDao;

    public Turma salvar(Turma turma){
        var result =turmaDao.salvar(turma);
        if (result != 1) {
            throw new IllegalStateException("Não Foi possível salvar o Curso");
        }
        return turma;
    }

    public void deletar(int id) {
        turmaDao.excluir(id);
    }

    public Turma atualizar(Turma turma){
       return turmaDao.atualizar(turma);
    }

    public List<Turma> buscarTurmaPorCurso(int id){
        return turmaDao.buscarPorCurso(id);
    }
}