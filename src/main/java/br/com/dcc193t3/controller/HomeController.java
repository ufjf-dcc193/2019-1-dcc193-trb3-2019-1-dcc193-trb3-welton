package br.com.dcc193t3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.UsuarioRepository;
import br.com.dcc193t3.model.Usuario;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping({"","/","home"})
    public String home(Model model){
        model.addAttribute("usuario", new Usuario());
        return "Home/login";
    }

    @RequestMapping("admin")
    public String admin(){
        return "ADMIN/home";
    }

    @RequestMapping("efetuarLogin")
    public String login(Usuario usario,Model model, HttpSession session){
        Usuario usuarioQuery = usuarioRepository.findFirstByEmailAndCodigoAcesso(usario.getEmail(),usario.getCodigoAcesso());
        if(usuarioQuery != null){
            session.setAttribute("usuarioLogado", usuarioQuery);
            model.addAttribute("avaliador", usuarioQuery);
            return "USER/home";
        }else{
            return "Home/login";
        }
    }

    @RequestMapping("cadastro")
    public String cadastro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "Home/cadastro";
    }

    @RequestMapping("salvarcadastro")
    public String salvarcadastro(Usuario usuario){
        usuarioRepository.save(usuario);
        return "Home/login";
    }
    
}