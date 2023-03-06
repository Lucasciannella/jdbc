package linkedrh.com.api.controller;

import linkedrh.com.api.dto.TurmaParticipanteDto;
import linkedrh.com.api.entity.Funcionario;
import linkedrh.com.api.service.TurmaParticipanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participantes")
@RequiredArgsConstructor
public class TurmaParticipanteController {

    private final TurmaParticipanteService turmaParticipanteService;

    @PostMapping
    public ResponseEntity<TurmaParticipanteDto> salvarParticipantes(@RequestBody TurmaParticipanteDto turmaParticipanteDto) {
        return ResponseEntity.ok(turmaParticipanteService.adicionarParticipante(turmaParticipanteDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Funcionario>> listarParticipantes(@PathVariable int id) {
        return ResponseEntity.ok(turmaParticipanteService.listarParticipantes(id));
    }

    @DeleteMapping("/{idTurma}/{idFuncionario}")
    public ResponseEntity<Void> excluirParticipantes(@PathVariable int idTurma, @PathVariable int idFuncionario) {
        turmaParticipanteService.excluirParticipantes(idTurma, idFuncionario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}