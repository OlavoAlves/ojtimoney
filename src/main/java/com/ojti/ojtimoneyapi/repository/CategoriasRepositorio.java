package com.ojti.ojtimoneyapi.repository;
import com.ojti.ojtimoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepositorio extends JpaRepository<Categoria, Long> {

}
