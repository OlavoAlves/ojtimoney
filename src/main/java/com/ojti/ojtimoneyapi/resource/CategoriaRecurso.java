package com.ojti.ojtimoneyapi.resource;

import java.util.List;

import com.ojti.ojtimoneyapi.model.Categoria;
import com.ojti.ojtimoneyapi.repository.CategoriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaRecurso {
    @Autowired
    private CategoriasRepositorio categoriasRepositorio;
    @GetMapping
    public List<Categoria> listar() {
        return categoriasRepositorio.findAll();
    }
}
