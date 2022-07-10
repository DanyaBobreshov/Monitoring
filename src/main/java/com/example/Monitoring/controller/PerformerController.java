package com.example.Monitoring.controller;

import com.example.Monitoring.model.Performer;
import com.example.Monitoring.service.PerformerService;
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
public class PerformerController {
    private final PerformerService performerService;
    private final UserService userService;

    @GetMapping("/performers")
    public String performers(@RequestParam (name = "SearchWord", required = false) String title,
                             Principal principal, Model model){
        model.addAttribute("performers", performerService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord",title);
        return "performers";
    }

    @GetMapping("/performer/edit/{id}")
    public String performerEdit (@PathVariable("id") Long id,
                                 Model model, Principal principal){
        Performer performer=performerService.findById(id);
        model.addAttribute("performer", performer);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "performer-edit";
    }

    @PostMapping("performer/edit/performer-edit/{id}")
    public String performerEdit(
            @RequestParam("name")String name,
            @RequestParam("phoneNumber")String phoneNumber,
            @RequestParam("reservePhoneNumber")String reservePhoneNumber,
            @PathVariable("id")Long id){
    Performer performer=performerService.findById(id);
    performerService.correct(performer,name,phoneNumber,reservePhoneNumber);
    return "redirect:/performers";
    }

    @PostMapping("performer/add")
    public String add(Performer performer, Principal principal){
        performerService.save(performer);
        return "redirect:/performers";
    }

    @GetMapping("performer/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        performerService.delete(id);
        return "redirect:/performers";
    }

}
