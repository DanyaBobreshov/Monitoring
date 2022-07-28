package com.example.Monitoring.controller;

import com.example.Monitoring.model.ModelOfTechnical;
import com.example.Monitoring.service.ModelOfTechnicalService;
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
public class ModelOfTechnicalController {
    private final UserService userService;
    private final ModelOfTechnicalService modelOfTechnicalService;

    @GetMapping("/modelOfTechnicals")
    public String modelOfTechnicals(@RequestParam (name="searchWord", required = false) String title,
                                   Principal principal, Model model){
        model.addAttribute("modelOfTechnicals", modelOfTechnicalService.list(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "modelOfTechnicals";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("modelOfTechnical/add")
    public String add(@RequestParam ("title") String title,
                      @RequestParam ("description") String description){
        ModelOfTechnical modelOfTechnical=new ModelOfTechnical();
        modelOfTechnicalService.correct(modelOfTechnical, title, description);
        return "redirect:/modelOfTechnicals";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("modelOfTechnical/edit/{id}")
    public String edit(@PathVariable ("id") Long id, Model model, Principal principal){
        ModelOfTechnical modelOfTechnical = modelOfTechnicalService.findById(id);
        model.addAttribute("modelOfTechnical", modelOfTechnical);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "modelOfTechnical-edit";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("modelOfTechnical/edit/modelOfTechnical-edit/{id}")
    public String edit(@RequestParam("title") String title,
                       @RequestParam("description") String description,
                       @PathVariable("id") Long id){
        ModelOfTechnical modelOfTechnical = modelOfTechnicalService.findById(id);
        modelOfTechnicalService.correct(modelOfTechnical, title, description);
        return "redirect:/modelOfTechnicals";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("modelOfTechnical/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        modelOfTechnicalService.findById(id);
        modelOfTechnicalService.delete(id);
        return "redirect:/modelOfTechnicals";
    }


}
