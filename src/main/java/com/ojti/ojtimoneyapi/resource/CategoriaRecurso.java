package com.ojti.ojtimoneyapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.ojti.ojtimoneyapi.model.Categoria;
import com.ojti.ojtimoneyapi.repository.CategoriasRepositorio;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/categorias")
public class CategoriaRecurso {
    @Autowired
    private CategoriasRepositorio categoriasRepositorio;
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Categoria> categorias = categoriasRepositorio.findAll();
        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriasRepositorio.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
         response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriasRepositorio.findById(codigo);

        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) :  ResponseEntity.notFound().build();
    }
}
