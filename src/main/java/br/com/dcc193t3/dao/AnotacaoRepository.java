package br.com.dcc193t3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnotacaoRepository<Anotacao> extends JpaRepository<Anotacao, Long> {

    
}