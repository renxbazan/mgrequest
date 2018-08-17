package com.renx.mg.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renx.mg.request.model.Usuario;

@Controller
public class HelloController {

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "login";
  }

  @PostMapping("/hello")
  public String sayHello(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
  }
}
