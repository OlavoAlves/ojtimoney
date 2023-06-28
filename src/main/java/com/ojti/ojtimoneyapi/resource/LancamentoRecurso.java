package com.ojti.ojtimoneyapi.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ojti.ojtimoneyapi.event.RecursoCriadoEvent;
import com.ojti.ojtimoneyapi.model.Lancamento;
import com.ojti.ojtimoneyapi.repository.LancamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoRecurso {

    @Column(name = "data_vencimento")
    @JsonFormat(pattern =  "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    @JsonFormat(pattern =  "dd/MM/yyyy")
    private LocalDate dataPagamento;

    @Autowired
    private LancamentoRepositorio lancamentoRepository;

    @GetMapping
    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Lancamento> lancamento = lancamentoRepository.findById(codigo);
        return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();
    }

}
