package br.com.dcc193t3.controller.user;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.dao.VinculoRepository;
import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Vinculo;

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

    @Autowired
    VinculoRepository vinculoRepository;

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
        return "redirect:/user/item/";
    }
    @RequestMapping("/gerenciarVinculo/{id}")
    public String gerenciarVinculo(@PathVariable Long id,Model model,HttpSession session){
        session.setAttribute("idItem", id);
        Item item = itemRepository.findById(id).get();
        List<Vinculo> listaVinculo = vinculoRepository.findAllByItemOrigemOrItemDestino(item, item);
        model.addAttribute("item",item);
        model.addAttribute("listaVinculo",listaVinculo);
        return "USER/item/gerenciar-vinculo-item";
    }

    @RequestMapping("/editar/{id}")
    public String editarItem(@PathVariable Long id, Model model){
        model.addAttribute("item",itemRepository.findById(id).get());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "USER/item/editar-item";
    }

    @RequestMapping("/deletarVinculo/{id}")
    public String deletarVinculo(@PathVariable Long id,HttpSession session){
        Long idItem = (Long) session.getAttribute("idItem");
        vinculoRepository.deleteById(id);
        return "redirect:/user/item/gerenciarVinculo/"+idItem;
    }
    @RequestMapping("/editar/salvar")
    public String editarsalvarItem(Item item){
        itemRepository.save(item);
        return "redirect:/user/item/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Item item){
        itemRepository.save(item);
        return "redirect:/user/item/";
    }
    
    @RequestMapping("/editarVinculo/{id}")
    public String editarVinculo(@PathVariable Long id, Model model){
        model.addAttribute("listaDestino",itemRepository.findAll());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        model.addAttribute("vinculo",vinculoRepository.findById(id).get());
        return "USER/item/editar-vinculo-item";
    }

    @RequestMapping("/editarVinculo/salvar")
    public String editarsalvarVinculo(Vinculo vinculo,HttpSession session){
        vinculoRepository.save(vinculo);
        Long idItem = (Long) session.getAttribute("idItem");
        return "redirect:/user/item/gerenciarVinculo/"+idItem;
    }
    @RequestMapping("/criarVinculo")
    public String criarVinculo(Model model){
        model.addAttribute("vinculo",new Vinculo());
        model.addAttribute("listaOrigem",itemRepository.findAll());
        model.addAttribute("listaDestino",itemRepository.findAll());
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "USER/item/criar-vinculo-item";
    }
    @RequestMapping("/criarVinculo/salvar")
    public String salvarTrabalho(Vinculo vinculo,HttpSession session){
        Long idItem = (Long) session.getAttribute("idItem");
        Item item = itemRepository.getOne(idItem);
        vinculo.setItemOrigem(item);
        vinculoRepository.save(vinculo);
        return "redirect:/user/item/gerenciarVinculo/"+idItem;
    }
}