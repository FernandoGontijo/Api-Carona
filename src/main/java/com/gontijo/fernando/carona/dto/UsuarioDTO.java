package com.gontijo.fernando.carona.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {


    private static final long serialVersionUID = 1L;


    private Integer id;

    private String email;

    private String nome;

    private String senha;

    private int telefone;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String email, String nome, String senha, int telefone) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
