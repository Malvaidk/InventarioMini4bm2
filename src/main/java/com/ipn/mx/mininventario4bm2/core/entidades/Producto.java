package com.ipn.mx.mininventario4bm2.core.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name="nombreProducto", length=50, nullable=false)
    private String nombreProducto;

    @Column(name="descripcionProducto", length=100, nullable=false)
    private String descripcionProducto;

    @Column(name="precioProducto", length=50, nullable=false, scale=2)
    private double precioProducto;

    @Column(name="existencia", nullable=false)
    private int existencia;

    @Column(name="create_At", nullable=true)
    private LocalDateTime createAt;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idCategoria")
    private Categoria idCategoria;
}
