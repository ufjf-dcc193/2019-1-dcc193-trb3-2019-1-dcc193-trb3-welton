package br.com.dcc193t3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t3.model.Anotacao;
import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Usuario;
import br.com.dcc193t3.model.Vinculo;


@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {

    List<Anotacao> findAllByUsuario(Usuario usuario);

	List<Anotacao> findAllByItemOrderByDtInclusao(Item item);

	List<Anotacao> findAllByVinculoOrderByDtInclusao(Vinculo vinculo);
}