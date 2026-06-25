package com.ipn.mx.mininventario4bm2.features.producto.repository;

import com.ipn.mx.mininventario4bm2.core.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
