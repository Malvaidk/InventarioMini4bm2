package com.ipn.mx.mininventario4bm2.features.categoria.controller;

import com.ipn.mx.mininventario4bm2.core.entidades.Categoria;
import com.ipn.mx.mininventario4bm2.features.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }

    @GetMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria findById(@PathVariable Long id){
        return categoriaService.findById(id);
    }

    @PostMapping("/categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }

    @PutMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria, @PathVariable Long id){
        Categoria c = categoriaService.findById(id);
        c.setNombreCategoria(categoria.getNombreCategoria());
        c.setDescripcionCategoria(categoria.getDescripcionCategoria());
        c.setCreateAt(categoria.getCreateAt());

        return categoriaService.save(c);
    }
    @DeleteMapping("/categoria/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoriaService.deleteById(id);
    }


}
