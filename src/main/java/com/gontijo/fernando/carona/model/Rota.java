package com.gontijo.fernando.carona.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_rota")
public class Rota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_rota", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "origem", nullable = false)
    private String origem;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "horario")
    private Date horario;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "vagas")
    private int vagas;

    @Column(name = "obs")
    private String obs;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "id_usuario"))
    private Usuario usuario;

    public Rota(Integer id, String origem, String destino, Date horario, Double preco, int vagas, String obs, Usuario usuario) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.preco = preco;
        this.vagas = vagas;
        this.obs = obs;
        this.usuario = usuario;
    }

    public Rota() {
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
