package br.com.dcc193t3.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.model.Etiqueta;

/**
 * EitquetaController
 */
@Controller
@RequestMapping("user/etiqueta")
public class EitquetaController {

    @Autowired
    EtiquetaRepository etiquetaRepository;

    @RequestMapping("/")
    public String homeEtiqueta(Model model){
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "USER/etiqueta/home-etiqueta";
    }

    @RequestMapping("/criar")
    public String criarEtiqueta(Model model){
        model.addAttribute("etiqueta",new Etiqueta());
        return "USER/etiqueta/criar-etiqueta";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarEtiqueta(@PathVariable Long id){
        etiquetaRepository.deleteById(id);
        return "redirect:/user/etiqueta/";
    }

    @RequestMapping("/editar/{id}")
    public String editarEtiqueta(@PathVariable Long id, Model model){
        model.addAttribute("etiqueta",etiquetaRepository.findById(id).get());
        return "USER/etiqueta/editar-etiqueta";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarEtiqueta(Etiqueta etiqueta){
        etiquetaRepository.save(etiqueta);
        return "redirect:/user/etiqueta/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Etiqueta etiqueta){
        etiquetaRepository.save(etiqueta);
        return "redirect:/user/etiqueta/";
    }
}