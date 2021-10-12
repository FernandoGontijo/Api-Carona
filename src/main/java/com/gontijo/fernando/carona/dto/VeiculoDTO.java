package com.gontijo.fernando.carona.dto;

import com.gontijo.fernando.carona.model.Usuario;

import java.io.Serializable;

public class VeiculoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private int capacidade;

    private String modelo;

    private String ano;

    private Usuario usuario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Integer id, int capacidade, String modelo, String ano, Usuario usuario) {
        this.id = id;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.ano = ano;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
