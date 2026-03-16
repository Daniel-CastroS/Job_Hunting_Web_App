package presentation.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import logic.Service;

@org.springframework.stereotype.Controller("empresa")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/presentation/empresa/show")
    public String show(Model model) {
        model.addAttribute("empresas", service.empresasAll());
        return "presentation/empresa/show";
    }
}