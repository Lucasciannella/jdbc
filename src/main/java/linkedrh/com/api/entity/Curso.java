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
    private int codigo;
    private String nome;
    private String descricao;
    private int duracao;
}