package linkedrh.com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private Integer codigo;
    private String nome;
    private String descricao;
    private Integer duracao;
}