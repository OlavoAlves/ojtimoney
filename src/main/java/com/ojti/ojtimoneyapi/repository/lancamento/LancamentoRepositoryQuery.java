package com.ojti.ojtimoneyapi.repository.lancamento;

import com.ojti.ojtimoneyapi.model.Lancamento;
import com.ojti.ojtimoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

}
