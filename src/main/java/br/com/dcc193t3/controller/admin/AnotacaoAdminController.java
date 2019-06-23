package br.com.dcc193t3.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.AnotacaoRepository;
import br.com.dcc193t3.model.Anotacao;

/**
 * AnotacaoAdminController
 */
@Controller
@RequestMapping("admin/anotacao")
public class AnotacaoAdminController {

    @Autowired
    AnotacaoRepository anotacaoRepository;

    @RequestMapping("/")
    public String homeAdminAnotacao(Model model){
        model.addAttribute("listaAnotacao",anotacaoRepository.findAll());
        return "ADMIN/anotacao/home-anotacao";
    }

    @RequestMapping("/criar")
    public String criarAnotacao(Model model){
        model.addAttribute("anotacao",new Anotacao());
        return "ADMIN/anotacao/criar-anotacao";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarAdminAnotacao(@PathVariable Long id){
        anotacaoRepository.deleteById(id);
        return "redirect:/admin/anotacao/";
    }

    @RequestMapping("/editar/{id}")
    public String editarAdminAnotacao(@PathVariable Long id, Model model){
        model.addAttribute("anotacao",anotacaoRepository.findById(id).get());
        return "ADMIN/anotacao/editar-anotacao";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarAdminAnotacao(Anotacao anotacao){
        anotacaoRepository.save(anotacao);
        return "redirect:/admin/anotacao/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Anotacao anotacao){
        anotacaoRepository.save(anotacao);
        return "redirect:/admin/anotacao/";
    }
    
}