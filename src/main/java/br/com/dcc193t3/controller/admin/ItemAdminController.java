package br.com.dcc193t3.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.model.Item;

/**
 * ItemAdminController
 */
@Controller
@RequestMapping("admin/item")
public class ItemAdminController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EtiquetaRepository etiquetaRepository;

    @RequestMapping("/")
    public String homeAdminItem(Model model){
        model.addAttribute("listaItem",itemRepository.findAll());
        return "ADMIN/item/home-item";
    }

    @RequestMapping("/criar")
    public String criarItem(Model model){
        model.addAttribute("item",new Item());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "ADMIN/item/criar-item";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarAdminItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        return "redirect:/admin/item/";
    }

    @RequestMapping("/editar/{id}")
    public String editarAdminItem(@PathVariable Long id, Model model){
        model.addAttribute("item",itemRepository.findById(id).get());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "ADMIN/item/editar-item";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarAdminItem(Item item){
        itemRepository.save(item);
        return "redirect:/admin/item/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Item item){
        itemRepository.save(item);
        return "redirect:/admin/item/";
    }
    
}