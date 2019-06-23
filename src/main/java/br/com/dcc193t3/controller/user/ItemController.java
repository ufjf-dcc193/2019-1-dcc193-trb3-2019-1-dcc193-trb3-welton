package br.com.dcc193t3.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.model.Item;

/**
 * ItemController
 */
@Controller
@RequestMapping("user/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EtiquetaRepository etiquetaRepository;

    @RequestMapping("/")
    public String homeItem(Model model){
        model.addAttribute("listaItem",itemRepository.findAll());
        return "USER/item/home-item";
    }

    @RequestMapping("/criar")
    public String criarItem(Model model){
        model.addAttribute("item",new Item());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "USER/item/criar-item";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        return "redirect:/admin/item/";
    }

    @RequestMapping("/editar/{id}")
    public String editarItem(@PathVariable Long id, Model model){
        model.addAttribute("item",itemRepository.findById(id).get());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "USER/item/editar-item";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarItem(Item item){
        itemRepository.save(item);
        return "redirect:/admin/item/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Item item){
        itemRepository.save(item);
        return "redirect:/admin/item/";
    }
    
}