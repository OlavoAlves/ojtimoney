package com.ojti.ojtimoneyapi.repository;

import com.ojti.ojtimoneyapi.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepositorio extends JpaRepository<Lancamento, Long> {

}
