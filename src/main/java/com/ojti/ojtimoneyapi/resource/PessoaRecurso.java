package com.ojti.ojtimoneyapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojti.ojtimoneyapi.event.RecursoCriadoEvent;
import com.ojti.ojtimoneyapi.model.Pessoa;
import com.ojti.ojtimoneyapi.repository.PessoasRepositorio;

@RestController
@RequestMapping("/pessoas")
public class PessoaRecurso {

    @Autowired
    private PessoasRepositorio pessoaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }
    @GetMapping("/{codigo}")
    public Pessoa buscarPeloCodigo(@PathVariable Long codigo) {
        return this.pessoaRepository.findById(codigo).orElse(null);
    }
}
