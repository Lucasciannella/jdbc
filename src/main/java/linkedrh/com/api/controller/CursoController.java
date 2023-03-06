package linkedrh.com.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import linkedrh.com.api.dto.CursoPostDto;
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
@CrossOrigin("*")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    @Operation(summary = "Salva um curso")
    public ResponseEntity<CursoPostDto> salvar(@RequestBody CursoPostDto cursoPostDto) {
        return new ResponseEntity<>(cursoService.salvar(cursoPostDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Lista todos os cursos")
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PutMapping
    @Operation(summary = "Atualiza um curso")
    public ResponseEntity<Curso> atualizar(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.atualizar(curso), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um curso ")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cursoService.deletarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}