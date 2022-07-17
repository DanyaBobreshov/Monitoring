package com.example.Monitoring.controller;

import com.example.Monitoring.model.Incident;
import com.example.Monitoring.service.IncidentService;
import com.example.Monitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class IncidentController {
    private final UserService userService;
    private final IncidentService incidentService;

    @GetMapping("/incidents")
    public String incidents(@RequestParam(name="searchWord", required = false)Date dateSQL,
                            Principal principal, Model model){
        if (dateSQL!=null) {
            LocalDateTime dateTime = dateSQL.toLocalDate().atTime(12, 0);
            model.addAttribute("incidents", incidentService.list(dateTime));
        }else {
            LocalDateTime dateTime =null;
            model.addAttribute("incidents", incidentService.list(dateTime));
        }
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", dateSQL);
        return "incidents";
    }

    @PostMapping("incidents/add")
    public String add(@RequestParam ("product") Long product,
                      @RequestParam (name="isGarant", required = false) Boolean isGarant,
                      @RequestParam ("description") String description,
                      @RequestParam ("dateOfIncident") Date dateOfIncident){
        Incident incident = new Incident();
        if(isGarant==null) isGarant=false;
        incidentService.correct(incident, product, isGarant, description, dateOfIncident.toLocalDate().atTime(12,0));
        return "redirect:/incidents";
    }

    @GetMapping("incidents/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, Principal principal){
        Incident incident = incidentService.findById(id);
        model.addAttribute("incident", incident);
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "incident-edit";
    }

    @PostMapping("incidents/edit/incident-edit/{id}")
    public String edit(@RequestParam ("product") Long product,
                       @RequestParam ("isGarant") Boolean isGarant,
                       @RequestParam ("description") String description,
                       @RequestParam ("dateOfIncident") Date dateOfIncident,
                       @PathVariable("id") Long id){
        Incident incident=incidentService.findById(id);
        incidentService.correct(incident, product, isGarant, description, dateOfIncident.toLocalDate().atTime(12,0));
        return "redirect:/incidents";
    }

    @GetMapping("incidents/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        incidentService.delete(id);
        return "redirect:/incidents";
    }
}
