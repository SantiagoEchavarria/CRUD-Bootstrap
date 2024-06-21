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
@SessionAttributes({"huesped"})
public class HuespedControl {
    @Autowired
    private HuespedInterface huespedServicio;
    @Autowired
    private DestinoInterface destinoServicio;
 
    public HuespedControl() {
    }
 
    @GetMapping({"/huespedInsertar"})
    public String huespedInsertar(Model model) {
       Huesped huesped = new Huesped();
       model.addAttribute("huesped", huesped);
       model.addAttribute("mensaje", "Nuevo Producto");
       return "huespedInsertar";
    }
 
    @ModelAttribute("destino")
    public List<Destino> datosDestinos() {
       return this.destinoServicio.listadoDestinos();
    }
 
    @PostMapping({"/insertarHuesped"})
    public String insertarHuesped(@ModelAttribute(name = "huesped") Huesped huesped, Model model, SessionStatus status) {
       this.huespedServicio.guardarHuesped(huesped);
       status.setComplete();
       return "huespedInsertar";
    }
 
    @GetMapping({"/huespedListar"})
    public String huespedListar(Model model) {
       List<Huesped> huesped = this.huespedServicio.listadoHuesped();
       model.addAttribute("huesped", huesped);
       model.addAttribute("mensaje", "Listado Huespeds");
       return "huespedListar";
    }
}
