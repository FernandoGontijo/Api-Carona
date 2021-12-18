package com.gontijo.fernando.carona.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "telefone", nullable = false)
    private Long telefone;

    @Column(name = "token_senha")
    private String tokenSenha;

    public Usuario(Integer id, String email, String nome, String senha, Long telefone) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTokenSenha() {
        return tokenSenha;
    }

    public void setTokenSenha(String tokenSenha) {
        this.tokenSenha = tokenSenha;
    }
}
