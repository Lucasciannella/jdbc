package linkedrh.com.api.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TurmaPostDto {
    private LocalDate inicio;
    private LocalDate fim;
    private String local;
    private Integer codigoCurso;
}