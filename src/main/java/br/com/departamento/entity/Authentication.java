package br.com.departamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbUsuario")
public class Authentication {

    @Id
    @Column(name = "IdUsuario")
    private Long IdUsuario;

    @Column (name = "NomeUsuario")
    private String NomeUsuario;

    @Column(name = "segredo")
    private String segredo;

    public Authentication(Long IdUsuario,String NomeUsuario, String segredo){
        this.IdUsuario = IdUsuario;
        this.NomeUsuario = NomeUsuario;
        this.segredo = segredo;
    }
    public Authentication(){ }
}
