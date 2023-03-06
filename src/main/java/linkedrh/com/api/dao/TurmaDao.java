package linkedrh.com.api.dao;

import linkedrh.com.api.dto.TurmaPostDto;
import linkedrh.com.api.dto.TurmaPutDto;
import linkedrh.com.api.entity.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaDao {
    public int salvar(TurmaPostDto turmaPostDto);

    public int atualizar(TurmaPutDto turmaPutDto);

    public void excluir(int id);

    public List<Turma> buscarPorCurso(int idCurso);

    Optional<Turma> buscarCursoPorId(int id);
}