package com.ipn.mx.mininventario4bm2.features.producto.controller;

import com.ipn.mx.mininventario4bm2.core.entidades.Producto;
import com.ipn.mx.mininventario4bm2.features.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> findAll() { // <-- Cambia Repository por Producto
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto p = productoService.findById(id);
        //puede retornar null, hay qur validar
        p.setNombreProducto(producto.getNombreProducto());
        p.setDescripcionProducto(producto.getDescripcionProducto());
        p.setExistencia(producto.getExistencia());
        p.setPrecioProducto(producto.getPrecioProducto());
        p.setCreateAt(producto.getCreateAt());
        p.setIdCategoria(producto.getIdCategoria());
        return productoService.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}
