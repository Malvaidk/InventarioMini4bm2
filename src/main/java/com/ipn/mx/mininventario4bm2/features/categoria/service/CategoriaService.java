package com.ipn.mx.mininventario4bm2.features.categoria.service;

import com.ipn.mx.mininventario4bm2.core.entidades.Categoria;

import java.util.List;

public interface CategoriaService {
    public List<Categoria> findAll();
    public Categoria findById(Long id);
    public Categoria save(Categoria categoria);
    public void deleteById(Long id);

}
