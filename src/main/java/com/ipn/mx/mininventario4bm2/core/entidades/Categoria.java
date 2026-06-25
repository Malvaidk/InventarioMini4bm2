package com.ipn.mx.mininventario4bm2.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name= "Categoria") /*Crea una tabla*/

public class Categoria implements Serializable {
    @Id /*Dice que la categoria es ID*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Dice que es auto-increment */
    @Column( nullable=false)
    private Long  idCategoria;

    @Size(min = 4, max = 50, message="debe estar entre 4 y 50")
    @Column( length=50, nullable=false)
    private String nombreCategoria;

    @Column(length=100, nullable=false)
    private String descripcionCategoria;

    @Column(name="create_At", nullable=true)
    private LocalDateTime createAt;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    private Set <Producto> productos = new HashSet<Producto>();


}
