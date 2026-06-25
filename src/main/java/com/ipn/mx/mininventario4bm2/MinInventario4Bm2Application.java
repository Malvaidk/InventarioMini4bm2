package com.ipn.mx.mininventario4bm2;

import com.ipn.mx.mininventario4bm2.core.entidades.Categoria;
import com.ipn.mx.mininventario4bm2.features.categoria.repository.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinInventario4Bm2Application implements CommandLineRunner {
    @Autowired
    private CategoriaDAO dao;

    @Override
    public void run(String... args) throws Exception {}

    public static void main(String[] args) {
        SpringApplication.run(MinInventario4Bm2Application.class, args);
    }

}
