package linkedrh.com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private Integer codigo;
    private String nome;
    private String descricao;
    private Integer duracao;
}