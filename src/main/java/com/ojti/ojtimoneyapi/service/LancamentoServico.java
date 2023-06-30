package com.ojti.ojtimoneyapi.service;

import com.ojti.ojtimoneyapi.model.Lancamento;
import com.ojti.ojtimoneyapi.model.Pessoa;
import com.ojti.ojtimoneyapi.repository.LancamentoRepositorio;
import com.ojti.ojtimoneyapi.repository.PessoasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoServico {
    @Autowired
    private PessoasRepositorio pessoaRepository;

    @Autowired
    private LancamentoRepositorio lancamentoRepositoriy;
//    public Lancamento salvar(Lancamento lancamento) {
//        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
//        if (pessoa == null !! pessoa.isInativo()) {
//            throw new PessoaInexistenteOuInativaException();
//        }
//        return pessoaRepository.save(lancamento);
//    }

}
