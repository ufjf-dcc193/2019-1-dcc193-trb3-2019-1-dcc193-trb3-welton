package br.com.dcc193t3.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.model.Etiqueta;

/**
 * EitquetaAdminController
 */
@Controller
@RequestMapping("admin/etiqueta")
public class EitquetaAdminController {

    @Autowired
    EtiquetaRepository etiquetaRepository;

    @RequestMapping("/")
    public String homeAdminEtiqueta(Model model){
        model.addAttribute("listaEtiqueta",etiquetaRepository.findAll());
        return "ADMIN/etiqueta/home-etiqueta";
    }

    @RequestMapping("/criar")
    public String criarEtiqueta(Model model){
        model.addAttribute("etiqueta",new Etiqueta());
        return "ADMIN/etiqueta/criar-etiqueta";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarAdminEtiqueta(@PathVariable Long id){
        etiquetaRepository.deleteById(id);
        return "redirect:/admin/etiqueta/";
    }

    @RequestMapping("/editar/{id}")
    public String editarAdminEtiqueta(@PathVariable Long id, Model model){
        model.addAttribute("etiqueta",etiquetaRepository.findById(id).get());
        return "ADMIN/etiqueta/editar-etiqueta";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarAdminEtiqueta(Etiqueta etiqueta){
        etiquetaRepository.save(etiqueta);
        return "redirect:/admin/etiqueta/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Etiqueta etiqueta){
        etiquetaRepository.save(etiqueta);
        return "redirect:/admin/etiqueta/";
    }
}