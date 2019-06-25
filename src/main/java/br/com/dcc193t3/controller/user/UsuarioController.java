package br.com.dcc193t3.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.UsuarioRepository;
import br.com.dcc193t3.model.Usuario;

/**
 * UsuarioController
 */
@Controller
@RequestMapping("user/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/")
    public String homeUsuario(HttpSession session,Model model){
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        List<Usuario> usuariolista = new ArrayList<>();
        usuariolista.add(usuarioLogado);
        model.addAttribute("listaUsuario",usuariolista);
        return "USER/usuario/home-usuario";
    }

    @RequestMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return "redirect:/user/usuario/";
    }

    @RequestMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario",usuarioRepository.findById(id).get());
        return "USER/usuario/editar-usuario";
    }

    @RequestMapping("/editar/salvar")
    public String editarsalvarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/user/usuario/";
    }

    @RequestMapping("/salvar")
    public String salvarTrabalho(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/user/usuario/";
    }
}