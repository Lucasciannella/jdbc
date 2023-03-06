package linkedrh.com.api.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Funcionario {
    private Integer codigo;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String cargo;
    private Date admissao;
    private boolean status;
}