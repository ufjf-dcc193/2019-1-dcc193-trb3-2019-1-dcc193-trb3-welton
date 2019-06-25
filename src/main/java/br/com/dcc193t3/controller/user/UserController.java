package br.com.dcc193t3.controller.user;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.AnotacaoRepository;
import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.dao.VinculoRepository;
import br.com.dcc193t3.model.Anotacao;
import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Usuario;
import br.com.dcc193t3.model.Vinculo;

/**
 * UserController
 */
@Controller
@RequestMapping("user/")
public class UserController {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EtiquetaRepository etiquetaRepository;

    @Autowired
    AnotacaoRepository anotacaoRepository;

    @Autowired
    VinculoRepository vinculoRepository;

    @RequestMapping("buscarItem")
    public String homeItem(Item item, Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        model.addAttribute("listaItem", itemRepository.findAllDistinctByTituloContainingAndEtiquetaIn(item.getTitulo(),item.getEtiqueta()));
        model.addAttribute("usuario", usuarioLogado);
        model.addAttribute("item", item);
        return "USER/home";
    }

    @RequestMapping("exibiritem/{id}")
    public String exibiritem(@PathVariable Long id, Model model) {
        Item item = itemRepository.getOne(id);
        model.addAttribute("item", item);
        model.addAttribute("anotacao", new Anotacao());
        model.addAttribute("listaAnotacao", anotacaoRepository.findAllByItemOrderByDtInclusao(item));
        System.out.println(anotacaoRepository.findAllByItemOrderByDtInclusao(item).size());
        return "USER/item";
    }

    @RequestMapping("vinculoBusca")
    public String vinculoBusca(Model model) {
        model.addAttribute("listaVinculo", vinculoRepository.findAll());
        return "USER/vinculoBusca";
    }

    @RequestMapping("salvarNovaAnotacaoItem/{id}")
    public String salvarNovaAnotacaoItem(@PathVariable Long id, Anotacao anotacao, HttpSession session) {
        anotacao.setId(null);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        anotacao.setUsuario(usuarioLogado);
        Item item = itemRepository.getOne(id);
        anotacao.setDtInclusao(new Date());
        anotacao.setDtAlteracao(new Date());
        anotacao.setItem(item);
        anotacaoRepository.save(anotacao);
        return "redirect:/user/exibiritem/" + id;
    }

    @RequestMapping("salvarNovaAnotacaoVinculo/{id}")
    public String salvarNovaAnotacaoVinculo(@PathVariable Long id, Anotacao anotacao, HttpSession session) {
        anotacao.setId(null);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        anotacao.setUsuario(usuarioLogado);
        Vinculo vinculo = vinculoRepository.getOne(id);
        anotacao.setDtInclusao(new Date());
        anotacao.setDtAlteracao(new Date());
        anotacao.setVinculo(vinculo);
        anotacaoRepository.save(anotacao);
        return "redirect:/user/exibirVinculo/" + id;
    }

    @RequestMapping("exibirVinculo/{id}")
    public String exibirVinculo(@PathVariable Long id, Model model) {
        Vinculo vinculo = vinculoRepository.getOne(id);
        model.addAttribute("vinculo", vinculo);
        model.addAttribute("anotacao", new Anotacao());
        model.addAttribute("listaAnotacao", anotacaoRepository.findAllByVinculoOrderByDtInclusao(vinculo));
        return "USER/vinculo";
    }
}