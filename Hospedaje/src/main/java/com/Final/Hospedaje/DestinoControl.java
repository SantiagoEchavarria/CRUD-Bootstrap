package com.Final.Hospedaje;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes({"destino"})
public class DestinoControl {
    @Autowired
    private DestinoInterface destinoServicio;
 
    public DestinoControl() {
    }
 
    @GetMapping({"destinoInsertar"})
    public String destinoInsertar(Model model) {
       Destino destino = new Destino();
       model.addAttribute("destino", destino);
       model.addAttribute("mensaje", "nueva Destino");
       return "destinoInsertar";
    }
 
    @PostMapping({"/insertarDestino"})
    public String insertarDestino(@ModelAttribute(name = "destino") Destino destino, 
    Model model, SessionStatus status) {
       this.destinoServicio.guardarDestino(destino);
       status.setComplete();
       return "redirect:destinoListar";
    }
 
    @GetMapping({"/destinoListar"})
    public String destinoListar(Model model) {
       List<Destino> destino = this.destinoServicio.listadoDestinos();
       model.addAttribute("destino", destino);
       model.addAttribute("mensaje", "Listado de DEstinos");
       return "destinoListar";
    }
}
