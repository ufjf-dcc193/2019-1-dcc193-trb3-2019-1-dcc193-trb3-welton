package br.com.dcc193t3.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.UsuarioRepository;
import br.com.dcc193t3.model.Usuario;

/**
 * UsuarioAdminController
 */
@Controller
@RequestMapping("admin/usuario")
public class UsuarioAdminController {

    
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/")
    public String homeAdminUsuario(Model model){
        model.addAttribute("listaUsuario",usuarioRepository.findAll());
        return "ADMIN/usuario/home-usuario";
    }

    @RequestMapping("/criar")
    public String criarUsuario(Model model){
        model.addAttribute("usuario",new Usuario());
        return "ADMIN/usuario/criar-usuario";
    }
    @RequestMapping("/deletar/{id}")
    public String deletarAdminUsuario(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return "redirect:/admin/usuario/";
    }

    @RequestMapping("/editar/{id}")
    public String editarAdminUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario",usuarioRepository.findById(id).get());
        return "ADMIN/usuario/editar-usuario";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarAdminUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/admin/usuario/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/admin/usuario/";
    }
}