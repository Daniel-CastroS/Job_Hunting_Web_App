package presentation.Controllers;

import jakarta.servlet.http.HttpSession;
import logic.Admin;
import logic.Empresa;
import logic.Oferente;
import logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private Service service;

    // GET /login  → muestra el formulario
    @GetMapping("/login")
    public String loginForm() {
        return "login";   // templates/login.html
    }

    // POST /login → valida credenciales y redirige según rol
    @PostMapping("/login")
    public String loginSubmit(
            @RequestParam String rol,
            @RequestParam String usuario,
            @RequestParam String clave,
            HttpSession session) {

        switch (rol) {

            case "admin" -> {
                Admin admin = service.findAdminById(usuario);
                if (admin == null || !admin.getClave().equals(clave)) {
                    return "redirect:/login?error";
                }
                session.setAttribute("usuarioRol",  "admin");
                session.setAttribute("usuarioId",   admin.getId());
                session.setAttribute("usuarioNombre", admin.getNombre());
                return "redirect:/admin/dashboard";
            }

            case "empresa" -> {
                Empresa empresa = service.findEmpresaByCorreo(usuario);
                if (empresa == null || !empresa.getClave().equals(clave)) {
                    return "redirect:/login?error";
                }
                if (!empresa.isAprobada()) {
                    return "redirect:/login?inactivo";
                }
                session.setAttribute("usuarioRol",  "empresa");
                session.setAttribute("usuarioId",   empresa.getId());
                session.setAttribute("usuarioNombre", empresa.getNombre());
                return "redirect:/empresa/dashboard";
            }

            case "oferente" -> {
                Oferente oferente = service.findOferenteByCorreo(usuario);
                if (oferente == null || !oferente.getClave().equals(clave)) {
                    return "redirect:/login?error";
                }
                if (!oferente.isAprobado()) {
                    return "redirect:/login?inactivo";
                }
                session.setAttribute("usuarioRol",  "oferente");
                session.setAttribute("usuarioId",   oferente.getId());
                session.setAttribute("usuarioNombre", oferente.getNombre());
                return "redirect:/oferente/dashboard";
            }

            default -> { return "redirect:/login?error"; }
        }
    }

    // GET /logout → limpia sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
