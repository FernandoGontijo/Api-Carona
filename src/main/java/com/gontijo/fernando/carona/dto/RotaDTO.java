package com.gontijo.fernando.carona.dto;

import com.gontijo.fernando.carona.model.Usuario;

import java.io.Serializable;
import java.util.Date;

public class RotaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String origem;

    private String destino;

    private Date horario;

    private Double preco;

    private int vagas;

    private Usuario usuario;

    public RotaDTO() {
    }

    public RotaDTO(Integer id, String origem, String destino, Date horario, Double preco, int vagas, Usuario usuario) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.preco = preco;
        this.vagas = vagas;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
