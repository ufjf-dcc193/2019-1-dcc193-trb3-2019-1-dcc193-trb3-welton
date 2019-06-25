package br.com.dcc193t3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Vinculo;

/**
 * VinculoRepository
 */
@Repository
public interface VinculoRepository extends JpaRepository<Vinculo,Long> {

	List<Vinculo> findAllByItemOrigemOrItemDestino(Item item,Item item2);
}