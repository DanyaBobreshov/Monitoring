package com.example.Monitoring.controller;

import com.example.Monitoring.model.Incident;
import com.example.Monitoring.model.Product;
import com.example.Monitoring.model.User;
import com.example.Monitoring.service.IncidentService;
import com.example.Monitoring.service.ProductService;
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
    private final ProductService productService;

    @GetMapping("/incidents")
    public String incidents(@RequestParam(name="searchWord", required = false)Date dateSQL,
                            Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        String divisionTitle = user.getDivisionTitle();
        if(user.isAdmin()) {
            LocalDateTime dateTime;
            if (dateSQL != null) {
                dateTime = dateSQL.toLocalDate().atTime(12, 0);
            } else {
                dateTime = null;
            }
            model.addAttribute("incidents", incidentService.list(dateTime));
        }else {
            LocalDateTime dateTime;
            if (dateSQL != null) {
                dateTime = dateSQL.toLocalDate().atTime(12, 0);
            } else {
                dateTime = null;
            }
            model.addAttribute("incidents", incidentService.listDivision(dateTime, divisionTitle));
        }
        model.addAttribute("user", user);
        return "incidents";
    }

    @PostMapping("incidents/add")
    public String add(@RequestParam ("product") Long product,
                      @RequestParam (name="isGarant", required = false) Boolean isGarant,
                      @RequestParam ("description") String description,
                      @RequestParam ("dateOfIncident") Date dateOfIncident,
                      @RequestParam("industrial") String industrial,
                      @RequestParam("document") String document,
                      Principal principal){
        Incident incident = new Incident();
        User user = userService.getUserByPrincipal(principal);
        Product productEntity=productService.findById(product);
        System.out.println(productEntity.getId());
        if(isGarant==null) {
            isGarant = false;
        }else {
            isGarant = true;
        }
        if (productEntity.getRegiment().getDivision().getTitle().equals(user.getDivisionTitle()) || user.isAdmin()) {
            incidentService.correct(incident, product, isGarant, description, dateOfIncident.toLocalDate().atTime(12, 0),
                    industrial, document);
        }
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
                       @RequestParam (name="isGarant", required = false) Boolean isGarant,
                       @RequestParam ("description") String description,
                       @RequestParam ("dateOfIncident") Date dateOfIncident,
                       @RequestParam("industrial") String industrial,
                       @RequestParam("document") String document,
                       @PathVariable("id") Long id,
                       Principal principal){
        if(isGarant==null) {
            isGarant = false;
        }else {
            isGarant = true;
        }
        User user = userService.getUserByPrincipal(principal);
        Product productEntity=productService.findById(product);
        if (productEntity.getRegiment().getDivision().getTitle().equals(user.getDivisionTitle()) || user.isAdmin()) {
            Incident incident = incidentService.findById(id);
            incidentService.correct(incident, product, isGarant, description, dateOfIncident.toLocalDate().atTime(12, 0),
                    industrial, document);
        }
        return "redirect:/incidents";
    }

    @GetMapping("incidents/delete/{id}")
    public String delete(@PathVariable("id") Long id, Principal principal){
        User user = userService.getUserByPrincipal(principal);
        Product productEntity=incidentService.findById(id).getProduct();
        if (productEntity.getRegiment().getDivision().getTitle().equals(user.getDivisionTitle()) || user.isAdmin()) {
            incidentService.delete(id);
        }
        return "redirect:/incidents";
    }
}
