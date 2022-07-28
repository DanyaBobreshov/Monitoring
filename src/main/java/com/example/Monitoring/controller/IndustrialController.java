package com.example.Monitoring.controller;

import com.example.Monitoring.model.Industrial;
import com.example.Monitoring.service.IndustrialService;
import com.example.Monitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class IndustrialController {
    private final UserService userService;
    private final IndustrialService industrialService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/industrials")
    public String industrials (@RequestParam (name = "searchWord", required = false) String title,
                               Principal principal, Model model){
        model.addAttribute("industrials", industrialService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "industrials";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("industrial/add")
    public String add(@RequestParam("title") String title,
                      @RequestParam("address") String address,
                      @RequestParam("director") String director,
                      @RequestParam("directorName") String directorName,
                      @RequestParam("contactManager") String contactManager){
        Industrial industrial=new Industrial();
        industrialService.correct(industrial, title, address, director, directorName, contactManager);
        return "redirect:/industrials";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("industrial/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, Principal principal){
        Industrial industrial=industrialService.findById(id);
        model.addAttribute("industrial", industrial);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "industrial-edit";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("industrial/edit/industrial-edit/{id}")
    public String edit(@RequestParam ("title") String title,
                       @RequestParam("address") String address,
                       @RequestParam("director") String director,
                       @RequestParam("directorName") String directorName,
                       @RequestParam("contactManager") String contactManager,
                       @PathVariable("id") Long id){
        Industrial industrial=industrialService.findById(id);
        industrialService.correct(industrial, title, address,director,directorName,contactManager);
        return "redirect:/industrials";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("industrial/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        industrialService.delete(id);
        return "redirect:/industrials";
    }
}
