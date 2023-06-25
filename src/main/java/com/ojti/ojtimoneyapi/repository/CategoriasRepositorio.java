package com.ojti.ojtimoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojti.ojtimoneyapi.model.Categoria;

public interface CategoriasRepositorio extends JpaRepository<Categoria, Long> {

}