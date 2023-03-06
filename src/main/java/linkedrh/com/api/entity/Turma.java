package linkedrh.com.api.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class Turma {
    private Integer codigo;
    private LocalDate inicio;
    private LocalDate fim;
    private String local;
    private Integer codigo_curso;
    private List<Funcionario> TurmaParticipantes;
}