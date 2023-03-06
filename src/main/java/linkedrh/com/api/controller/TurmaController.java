package linkedrh.com.api.controller;

import linkedrh.com.api.dto.TurmaPostDto;
import linkedrh.com.api.dto.TurmaPutDto;
import linkedrh.com.api.entity.Turma;
import linkedrh.com.api.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turma")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Turma>> buscarTurmaPorCurso(@PathVariable int id) {
        return ResponseEntity.ok(turmaService.buscarTurmaPorCurso(id));
    }

    @PostMapping
    public ResponseEntity<TurmaPostDto> salvarTurma(@RequestBody TurmaPostDto turmaPostDto) {
        return ResponseEntity.ok(turmaService.salvar(turmaPostDto));
    }

    @PutMapping
    public ResponseEntity<TurmaPutDto> atualizarTurma(@RequestBody TurmaPutDto turmaPutDto) {
        return new ResponseEntity<>(turmaService.atualizar(turmaPutDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable int id) {
        turmaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}