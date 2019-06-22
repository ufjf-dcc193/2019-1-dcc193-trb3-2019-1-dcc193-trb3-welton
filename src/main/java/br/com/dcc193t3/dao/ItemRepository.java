package br.com.dcc193t3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t3.model.Item;

/**
 * ItemRepository
 */
@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

    
}