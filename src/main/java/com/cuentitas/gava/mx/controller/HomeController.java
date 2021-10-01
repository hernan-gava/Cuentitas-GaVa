package com.cuentitas.gava.mx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author hernan
 */
@Controller
public class HomeController {

    private static final String PAGINA_PRINCIPAL = "/Administrador";

    @GetMapping(value = PAGINA_PRINCIPAL)
    public String Admin() {
        return "Administrador-Page/Administrador";
    }

}
