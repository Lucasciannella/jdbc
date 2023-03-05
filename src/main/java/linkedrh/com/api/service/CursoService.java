package linkedrh.com.api.service;

import linkedrh.com.api.dto.Curso;
import linkedrh.com.api.exception.NotFoundException;
import linkedrh.com.api.repository.CursoDao;
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

    public Curso salvar(Curso curso) {
        var result = cursoDao.salvar(curso);
        if (result != 1) {
            throw new IllegalStateException("Algo  esta errado");
        }
        return curso;
    }

    public void deletarCurso(Integer id) {
        var cursos = cursoDao.buscarCursoPorId(id);
        cursos.ifPresentOrElse(curso -> {
            int result = cursoDao.deletar(id);
            if (result != 1) {
                throw new IllegalStateException("Não foi possível deletar o curso");
            }
        }, () -> {
            throw new NotFoundException(String.format("Curso com o id %s não existe ou ainda não foi adcionado", id));
        });
    }

    public Curso atualizar(Curso curso){
      var cursos = cursoDao.buscarCursoPorId(curso.getCodigo());
      cursos.ifPresentOrElse(curso1 -> {
          var result = cursoDao.atualizar(curso);
          if (result != 1){
          throw  new IllegalStateException("Não foi possível deletar o curso");

          }
      },() -> {
          throw  new NotFoundException(String.format("Curso com o id %s não encontrado",curso.getCodigo()));
              }
      );

     return curso;
    }

}