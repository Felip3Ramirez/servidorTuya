package com.example.PEDIDOSAPP.modelos;

import com.example.PEDIDOSAPP.ayudas.enums.EntregaEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Integer id;

    @Column
    private LocalDate fechaEntrega;

    @Column
    private EntregaEnum estadoEntrega;

    @ManyToOne
    @JoinColumn(name = "fk_repartidor", referencedColumnName = "id_repartidor")
    @JsonBackReference
    private Repartidor repartidor;

    @OneToMany(mappedBy = "entrega")
    @JsonManagedReference
    private List<Pedido> pedidos;

    public Entrega() {
    }

    public Entrega(Integer id, LocalDate fechaEntrega, EntregaEnum estadoEntrega) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
        this.estadoEntrega = estadoEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EntregaEnum getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(EntregaEnum estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
