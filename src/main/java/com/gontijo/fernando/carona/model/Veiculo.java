package com.gontijo.fernando.carona.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_veiculo", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "capacidade", nullable = false)
    private int capacidade;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private String ano;

    @Column(name = "placa")
    private String placa;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "id_usuario"))
    private Usuario usuario;

    public Veiculo(Integer id, int capacidade, String modelo, String ano, String placa, Usuario usuario) {
        this.id = id;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.usuario = usuario;
    }

    public Veiculo() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
