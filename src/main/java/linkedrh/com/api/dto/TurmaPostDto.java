package linkedrh.com.api.dto;

import linkedrh.com.api.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TurmaPostDto {
    private LocalDate inicio;
    private LocalDate fim;
    private String local;
    private Integer codigo_curso;
    private List<Funcionario> TurmaParticipantes;
}
