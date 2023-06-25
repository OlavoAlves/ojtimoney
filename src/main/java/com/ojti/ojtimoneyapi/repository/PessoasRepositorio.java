package com.ojti.ojtimoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojti.ojtimoneyapi.model.Pessoa;

public interface PessoasRepositorio extends JpaRepository<Pessoa, Long> {

}