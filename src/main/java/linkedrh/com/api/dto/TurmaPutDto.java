package linkedrh.com.api.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TurmaPutDto {
    private Integer codigo;
    private LocalDate inicio;
    private LocalDate fim;
    private String local;
}