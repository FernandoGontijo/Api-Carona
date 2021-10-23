package com.gontijo.fernando.carona.dto;

import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.model.Veiculo;

import java.io.Serializable;

public class VeiculoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private int capacidade;

    private String modelo;

    private String ano;

    private String placa;

    private Usuario usuario;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Integer id, int capacidade, String modelo, String ano, String placa, Usuario usuario) {
        this.id = id;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.usuario = usuario;
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.capacidade = veiculo.getCapacidade();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.placa = veiculo.getPlaca();
        this.usuario = veiculo.getUsuario();
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
