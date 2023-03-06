package linkedrh.com.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import linkedrh.com.api.entity.Curso;
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
    @Operation(summary = "Registra um curso na base de dados")
    public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.salvar(curso), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Atualiza um curso")
    public ResponseEntity<Curso> atualizar(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.atualizar(curso), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Lista todos os cursos")
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta ")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cursoService.deletarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}