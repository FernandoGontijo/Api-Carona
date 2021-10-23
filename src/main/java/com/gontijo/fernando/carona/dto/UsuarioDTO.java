package com.gontijo.fernando.carona.dto;

import com.gontijo.fernando.carona.model.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {


    private static final long serialVersionUID = 1L;


    private Integer id;

    private String email;

    private String nome;

    private String senha;

    private Long telefone;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String email, String nome, String senha, Long telefone) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.email = usuario.getEmail();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
        this.telefone = usuario.getTelefone();
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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
}
