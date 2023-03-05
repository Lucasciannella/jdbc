package linkedrh.com.api.controller;

import linkedrh.com.api.dto.Curso;
import linkedrh.com.api.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/curso")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> incluir(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.salvar(curso), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Curso> atualizar(@RequestBody Curso curso) {
      return new ResponseEntity<>(cursoService.atualizar(curso),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cursoService.deletarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}