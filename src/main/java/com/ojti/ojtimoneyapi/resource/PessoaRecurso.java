package com.ojti.ojtimoneyapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ojti.ojtimoneyapi.service.PessoaServico;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ojti.ojtimoneyapi.event.RecursoCriadoEvent;
import com.ojti.ojtimoneyapi.model.Pessoa;
import com.ojti.ojtimoneyapi.repository.PessoasRepositorio;

@RestController
@RequestMapping("/pessoas")
public class PessoaRecurso {

    @Autowired
    private PessoasRepositorio pessoaRepository;
    @Autowired
    private PessoaServico pessoaService;
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
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        this.pessoaRepository.deleteById(codigo);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }
    @PutMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {

    }
}
