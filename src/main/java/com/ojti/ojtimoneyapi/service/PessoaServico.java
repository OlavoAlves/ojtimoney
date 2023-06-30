package com.ojti.ojtimoneyapi.service;

import com.ojti.ojtimoneyapi.model.Pessoa;
import com.ojti.ojtimoneyapi.repository.PessoasRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaServico {
    @Autowired
    private PessoasRepositorio pessoaRepository;
    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElse(null);
        if(pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }

    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }
}
