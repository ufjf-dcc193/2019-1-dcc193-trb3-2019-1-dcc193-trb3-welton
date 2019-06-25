package br.com.dcc193t3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dcc193t3.dao.EtiquetaRepository;
import br.com.dcc193t3.dao.ItemRepository;
import br.com.dcc193t3.dao.UsuarioRepository;
import br.com.dcc193t3.model.Etiqueta;
import br.com.dcc193t3.model.Item;
import br.com.dcc193t3.model.Usuario;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EtiquetaRepository etiquetaRepository;

    @RequestMapping({"","/","home"})
    public String home(Model model){
        model.addAttribute("usuario", new Usuario());
        return "Home/login";
    }

    @RequestMapping("/admin/")
    public String admin(){
        return "ADMIN/home";
    }
    @RequestMapping("/admin")
    public String adminaux(){
        return "redirect:/admin/";
    }

    @RequestMapping("/efetuarLogin")
    public String login(Usuario usario,Model model, HttpSession session){
        Usuario usuarioQuery = usuarioRepository.findFirstByEmailAndCodigoAcesso(usario.getEmail(),usario.getCodigoAcesso());
        System.out.println(usario.toString());
        if(usuarioQuery != null){
            session.setAttribute("usuarioLogado", usuarioQuery);
            return "redirect:/user/";
        }else{
            return "Home/login";
        }
    }
    @RequestMapping("/user/")
    public String user(HttpSession session, Model model){
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        model.addAttribute("usuario", usuarioLogado);
        model.addAttribute("listaItem", itemRepository.findAll());
        List<Etiqueta> lista = etiquetaRepository.findAll();
        Item item = new Item();
        item.setEtiqueta(lista);
        model.addAttribute("item", item);
        model.addAttribute("listaEtiqueta",lista);
        return "USER/home";
    }
    @RequestMapping("/user")
    public String userAux(){
        return "redirect:/user/";
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