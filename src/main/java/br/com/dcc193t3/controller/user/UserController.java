package br.com.dcc193t3.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.AnotacaoRepository;
import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.model.Anotacao;
import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Usuario;

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
    
    @RequestMapping("buscarItem")
    public String homeItem(Item item, Model model,HttpSession session){
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        model.addAttribute("listaItem",itemRepository.findAllByText(item.getTitulo()));
        model.addAttribute("usuario", usuarioLogado);
        model.addAttribute("item", item);
        return "USER/home";
    }

    @RequestMapping("exibiritem/{id}")
    public String exibiritem(@PathVariable Long id,Model model){
        Item item = itemRepository.getOne(id);
        model.addAttribute("item", item);
        model.addAttribute("anotacao", new Anotacao());
        model.addAttribute("listaAnotacao", anotacaoRepository.findAllByItemOrderByDtInclusao(item));
        System.out.println(anotacaoRepository.findAllByItemOrderByDtInclusao(item).size());
        return "USER/item";
    }
}