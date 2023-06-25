package br.com.anubis.planner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anubis")
public class AnubisPlannerController {

    public AnubisPlannerController() {
        System.out.println("Anubis iniciado");
    }

    @RequestMapping("/ola/{nome}")
    @ResponseBody
    public String ola(@PathVariable String nome) {
        return "Olá, " + nome;
    }
}
