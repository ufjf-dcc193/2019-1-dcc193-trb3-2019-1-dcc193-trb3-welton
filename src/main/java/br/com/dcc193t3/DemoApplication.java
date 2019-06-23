package br.com.dcc193t3;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.dcc193t3.dao.AnotacaoRepository;
import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.dao.UsuarioRepository;
import br.com.dcc193t3.dao.VinculoRepository;
import br.com.dcc193t3.model.Anotacao;
import br.com.dcc193t3.model.Etiqueta;
import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Usuario;
import br.com.dcc193t3.model.Vinculo;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	AnotacaoRepository anotacaoRepository;
	@Autowired
	EtiquetaRepository etiquetaRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	VinculoRepository vinculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			usuarioRepository.save(new Usuario(null, "aaa", "aaa", "aaa", "aaaa@hotmail.com"));
			usuarioRepository.save(new Usuario(null, "Joao", "senha123", "usuario noob", "suarionoob@hotmail.com"));
			usuarioRepository.save(new Usuario(null, "pedro", "aaaa", "nem sei quem é", "pedro_file@gmail.com"));

			etiquetaRepository.save(new Etiqueta(null, "livro", "conjunto de folhas", "www.livro.com.br"));
			etiquetaRepository.save(new Etiqueta(null, "e-book", "livro digital", "www.e-book.com.br"));
			etiquetaRepository.save(new Etiqueta(null, "revista", "noticias", "www.revista.com.br"));
			etiquetaRepository.save(new Etiqueta(null, "artigo", "produção academica", "www.artigo.com.br"));
			etiquetaRepository.save(new Etiqueta(null, "enciclopedia", "enciclopedia academica", "www.enciclopedia.com.br"));


			itemRepository.save(new Item(null, "O principe", 
			Collections.unmodifiableList(Arrays.asList(
			etiquetaRepository.findById(1L).get(),
			etiquetaRepository.findById(2L).get(),
			etiquetaRepository.findById(3L).get())
			)));

			itemRepository.save(new Item(null, "Assim falava zaratustra", 
			Collections.unmodifiableList(Arrays.asList(
			etiquetaRepository.findById(3L).get(),
			etiquetaRepository.findById(5L).get())
			)));

			itemRepository.save(new Item(null, "Harry potter", 
			Collections.unmodifiableList(Arrays.asList(
			etiquetaRepository.findById(3L).get(),
			etiquetaRepository.findById(1L).get(),
			etiquetaRepository.findById(5L).get())
			)));

			itemRepository.save(new Item(null, "As riquezas das nações", 
			Collections.unmodifiableList(Arrays.asList(
			etiquetaRepository.findById(2L).get(),
			etiquetaRepository.findById(4L).get())
			)));

			itemRepository.save(new Item(null, "O capital", 
			Collections.unmodifiableList(Arrays.asList(
			etiquetaRepository.findById(1L).get())
			)));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			anotacaoRepository.save(new Anotacao(null, "livro muito bom", 
			"gostei bastante do livro", "www.uol", sdf.parse("01/01/2018"), sdf.parse("24/06/2018"), 
			usuarioRepository.findById(1L).get(), 
			itemRepository.findById(1L).get()));

			anotacaoRepository.save(new Anotacao(null, "ruim", 
			"livro ruim", "www.globo", sdf.parse("02/01/2018"), sdf.parse("02/01/2018"), 
			usuarioRepository.findById(1L).get(), 
			itemRepository.findById(1L).get()));

			anotacaoRepository.save(new Anotacao(null, "medio", 
			"livro não sei", "www.globo", sdf.parse("04/01/2018"), sdf.parse("02/01/2018"), 
			usuarioRepository.findById(2L).get(), 
			itemRepository.findById(2L).get()));

			vinculoRepository.save(new Vinculo(null, 
			itemRepository.getOne(1L),
			itemRepository.getOne(2L),
			Collections.unmodifiableList(Arrays.asList(
			etiquetaRepository.findById(1L).get(),
			etiquetaRepository.findById(2L).get(),
			etiquetaRepository.findById(3L).get())
			), 
			Collections.unmodifiableList(Arrays.asList(
			anotacaoRepository.findById(1L).get(),
			anotacaoRepository.findById(2L).get(),
			anotacaoRepository.findById(3L).get())
			)
			));


		};
	}
}
