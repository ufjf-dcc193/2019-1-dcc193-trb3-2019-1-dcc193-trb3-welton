package br.com.dcc193t3.controller.user;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.AnotacaoRepository;
import br.com.dcc193t3.model.Anotacao;
import br.com.dcc193t3.model.Usuario;

/**
 * AnotacaoController
 */
@Controller
@RequestMapping("user/anotacao")
public class AnotacaoController {

    @Autowired
    AnotacaoRepository anotacaoRepository;

    @RequestMapping("/")
    public String homeAnotacao(Model model,HttpSession session){
        Usuario usuariologado = (Usuario) session.getAttribute("usuarioLogado");
        model.addAttribute("listaAnotacao",anotacaoRepository.findAllByUsuario(usuariologado));
        return "USER/anotacao/home-anotacao";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarAnotacao(@PathVariable Long id){
        anotacaoRepository.deleteById(id);
        return "redirect:/admin/anotacao/";
    }

    @RequestMapping("/editar/{id}")
    public String editarAnotacao(@PathVariable Long id, Model model){
        model.addAttribute("anotacao",anotacaoRepository.findById(id).get());
        return "USER/anotacao/editar-anotacao";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarAnotacao(Anotacao anotacao){
        anotacao.setDtAlteracao(new Date());
        anotacaoRepository.save(anotacao);
        return "redirect:/admin/anotacao/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Anotacao anotacao,HttpSession session){
        Usuario usuariologado = (Usuario) session.getAttribute("usuarioLogado");
        anotacao.setUsuario(usuariologado);
        anotacaoRepository.save(anotacao);
        return "redirect:/admin/anotacao/";
    }
    
}