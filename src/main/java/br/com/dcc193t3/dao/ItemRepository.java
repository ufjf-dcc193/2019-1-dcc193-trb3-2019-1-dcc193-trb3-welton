package br.com.dcc193t3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dcc193t3.model.Etiqueta;
import br.com.dcc193t3.model.Item;

/**
 * ItemRepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

	List<Item> findAllDistinctByTituloContainingAndEtiquetaIn(String titulo, List<Etiqueta> etiqueta);


}