package linkedrh.com.api.service;

import linkedrh.com.api.dao.CursoDao;
import linkedrh.com.api.dto.CursoPostDto;
import linkedrh.com.api.entity.Curso;
import linkedrh.com.api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoDao cursoDao;

    public List<Curso> listarCursos() {
        return cursoDao.listarTodos();
    }

    public CursoPostDto salvar(CursoPostDto cursoPostDto) {
        var result = cursoDao.salvar(cursoPostDto);
        if (result != 1) {
            throw new IllegalStateException("Não Foi possível salvar o Curso");
        }
        return cursoPostDto;
    }

    public void deletarCurso(Integer id) {
        var cursos = cursoDao.buscarCursoPorId(id);
        cursos.ifPresentOrElse(curso -> {
            int result = cursoDao.deletar(id);
            if (result != 1) {
                throw new IllegalStateException("Não foi possível deletar o Curso");
            }
        }, () -> {
            throw new NotFoundException(String.format("Curso com o id %s não existe ou ainda não foi adcionado", id));
        });
    }

    public Curso atualizar(Curso curso) {
        var cursos = cursoDao.buscarCursoPorId(curso.getCodigo());
        cursos.ifPresentOrElse(curso1 -> {
                    var result = cursoDao.atualizar(curso);
                    if (result != 1) {
                        throw new IllegalStateException("Não foi possível deletar o curso");
                    }
                }, () -> {
                    throw new NotFoundException(String.format("Curso com o id %s não encontrado", curso.getCodigo()));
                }
        );
        return curso;
    }
}