package com.example.Monitoring.controller;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.service.DivisionService;
import com.example.Monitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class DivisionController {
    private final DivisionService divisionService;
    private final UserService userService;

    @GetMapping("/divisions")
    public String divisions(@RequestParam (name="SearchWord", required = false)String title,
                            Principal principal, Model model){
        model.addAttribute("divisions", divisionService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "divisions";
    }

    @PostMapping("/divisions/add")
    public String add(@RequestParam("title") String title,
                      @RequestParam("TOSOfficer") String TOSOfficerName,
                      Principal principal){
        Division division= new Division();
        divisionService.correct(division, title, TOSOfficerName);
        return "redirect:/divisions";
    }

    @GetMapping("/divisions/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, Principal principal){
        Division division=divisionService.findById(id);
        model.addAttribute("division", division);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "division-edit";
    }

    @PostMapping("division/edit/division-edit/{id}")
    public String edit(@RequestParam("title") String title,
                       @RequestParam("TOSOfficer") String TOSOfficerName,
                       @PathVariable("id") Long id){
        Division division=divisionService.findById(id);
        divisionService.correct(division,title,TOSOfficerName);
        return "redirect:/divisions";
    }

    @GetMapping("division/deleet/{id}")
    public String delete(@PathVariable("id")Long id){
        divisionService.delete(id);
        return "redirect:/divisions";
    }
}
