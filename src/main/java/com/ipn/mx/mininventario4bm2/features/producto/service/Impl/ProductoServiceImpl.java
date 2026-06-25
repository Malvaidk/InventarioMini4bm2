package com.ipn.mx.mininventario4bm2.features.producto.service.Impl;

import com.ipn.mx.mininventario4bm2.core.entidades.Producto;
import com.ipn.mx.mininventario4bm2.features.producto.repository.ProductoRepository;
import com.ipn.mx.mininventario4bm2.features.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() { // <-- Cambia Repository por Producto
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return (Producto) productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
