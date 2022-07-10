package com.example.Monitoring.controller;

import com.example.Monitoring.model.Regiment;
import com.example.Monitoring.service.RegimentService;
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
public class RegimentController {
    private final RegimentService regimentService;
    private final UserService userService;

    @GetMapping("regiments")
    public String regiments(@RequestParam (name = "searchWord", required = false)String title,
                            Principal principal, Model model){
        model.addAttribute("regiments", regimentService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "regiments";
    }

    @PostMapping("regiments/add")
    public String add(@RequestParam("title") String title,
                      @RequestParam("address") String address,
                      @RequestParam("division") String division){
        Regiment regiment = new Regiment();
        regimentService.correct(regiment, title, address,division);
        return "redirect:/regiments";
    }

    @GetMapping("regiments/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, Principal principal){
        Regiment regiment=regimentService.findById(id);
        model.addAttribute("regiment", regiment);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "regiments-edit";
    }

    @PostMapping("regiment/edit/regiment-edit/{id}")
    public String edit(@RequestParam("title") String title,
                       @RequestParam("address") String address,
                       @RequestParam("division") String division,
                       @PathVariable ("id") Long id){
        Regiment regiment=regimentService.findById(id);
        regimentService.correct(regiment,address,title,division);
        return "redirect:/regiments";
    }

    @GetMapping("regiment/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        regimentService.delete(id);
        return "redirect:/regiments";
    }
}
