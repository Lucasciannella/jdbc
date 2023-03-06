package linkedrh.com.api.controller;

import linkedrh.com.api.entity.Funcionario;
import linkedrh.com.api.entity.TurmaParticipante;
import linkedrh.com.api.service.ParticipanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participantes")
@RequiredArgsConstructor
public class ParticipanteController {

    private final ParticipanteService participanteService;

    @PostMapping
    public ResponseEntity<TurmaParticipante> salvarParticipantes(@RequestBody TurmaParticipante turmaParticipante) {
        return ResponseEntity.ok(participanteService.adicionarParticipante(turmaParticipante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Funcionario>> listarParticipantes(@PathVariable int id) {
        return ResponseEntity.ok(participanteService.listarParticipantes(id));
    }

    @DeleteMapping("/{idTurma}/{idFuncionario}")
    public ResponseEntity<Void> excluirParticipantes(@PathVariable int idTurma, @PathVariable int idFuncionario) {
        participanteService.excluirParticipantes(idTurma, idFuncionario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}