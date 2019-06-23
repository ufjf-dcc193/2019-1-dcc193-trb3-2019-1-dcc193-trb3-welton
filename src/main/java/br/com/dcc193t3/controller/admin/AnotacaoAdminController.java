package br.com.dcc193t3.controller.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.AnotacaoRepository;
import br.com.dcc193t3.dao.UsuarioRepository;
import br.com.dcc193t3.model.Anotacao;
import br.com.dcc193t3.model.Usuario;

/**
 * AnotacaoAdminController
 */
@Controller
@RequestMapping("admin/anotacao")
public class AnotacaoAdminController {

    @Autowired
    AnotacaoRepository anotacaoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/")
    public String homeAdminAnotacao(Model model){
        model.addAttribute("listaAnotacao",anotacaoRepository.findAll());
        return "ADMIN/anotacao/home-anotacao";
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
        anotacao.setDtAlteracao(new Date());
        anotacaoRepository.save(anotacao);
        return "redirect:/admin/anotacao/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Anotacao anotacao){
        Usuario usuarioAdmin = usuarioRepository.getOne(4L);
        anotacao.setUsuario(usuarioAdmin);
        anotacaoRepository.save(anotacao);
        return "redirect:/admin/anotacao/";
    }
    
}