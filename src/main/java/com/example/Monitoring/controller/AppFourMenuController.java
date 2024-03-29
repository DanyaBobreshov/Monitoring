package com.example.Monitoring.controller;

import com.example.Monitoring.model.User;
import com.example.Monitoring.service.AppFourMenuService;
import com.example.Monitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class AppFourMenuController {
    private final UserService userService;
    private final AppFourMenuService appFourMenuService;
    @GetMapping("/appFourMenu")
    public String appFourMenu(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "appFourMenu";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/appFour-divisions")
    public String appDivisions(@RequestParam(name="searchWord", required = false) String title,
                            Principal principal, Model model){
       model.addAttribute("incidents", appFourMenuService.listByDivision(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "appFour-divisions";
    }

    @GetMapping("/appFour-products")
    public String appProducts(@RequestParam(name="searchWord", required = false) String title,
                            Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByProducts(title));

        }else {
            model.addAttribute("incidents", appFourMenuService.listByProductsDivision(title, user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        model.addAttribute("searchWord", title);
        return "appFour-products";
    }

    @GetMapping("/appFour-industrials")
    public String appIndustrials(@RequestParam(name="searchWord", required = false) String title,
                              Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByIndustrials(title));
        }else {
            model.addAttribute("incidents", appFourMenuService.listByIndustrialsDivision(title, user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        model.addAttribute("searchWord", title);
        return "appFour-industrials";
    }

    @GetMapping("/appFour-garant")
    public String appGarant(Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByGarant());
        }else {
            model.addAttribute("incidents", appFourMenuService.listByGarantDivision(user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        return "appFour-garant";
    }

    @GetMapping("/appFour-nonGarant")
    public String appNonGarant(Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByNonGarant());
        }else {
            model.addAttribute("incidents", appFourMenuService.listByNonGarantDivision(user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        return "appFour-nonGarant";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/appFour60-divisions")
    public String appDivisionsDate(@RequestParam(name="searchWord", required = false) String title,
                               Principal principal, Model model){
        model.addAttribute("incidents", appFourMenuService.listByDivisionDate(title));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("searchWord", title);
        return "appFour60-divisions";
    }

    @GetMapping("/appFour60-products")
    public String appProductsDate(@RequestParam(name="searchWord", required = false) String title,
                              Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByProductsDate(title));
        }else {
            model.addAttribute("incidents", appFourMenuService.listByProductsDateDivision(title, user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        model.addAttribute("searchWord", title);
        return "appFour60-products";
    }

    @GetMapping("/appFour60-industrials")
    public String appIndustrialsDate(@RequestParam(name="searchWord", required = false) String title,
                                 Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByIndustrialsDate(title));
        }else {
            model.addAttribute("incidents", appFourMenuService.listByIndustrialsDateDivision(title, user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        model.addAttribute("searchWord", title);
        return "appFour60-industrials";
    }

    @GetMapping("/appFour60-garant")
    public String appGarantDate(Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByGarantDate());
        }else {
            model.addAttribute("incidents", appFourMenuService.listByGarantDateDivision(user.getDivisionTitle()));
        }
        model.addAttribute("user", user);
        return "appFour60-garant";
    }

    @GetMapping("/appFour60-nonGarant")
    public String appNonGarantDate(Principal principal, Model model){
        User user=userService.getUserByPrincipal(principal);
        if(user.isAdmin()){
            model.addAttribute("incidents", appFourMenuService.listByNonGarantDate());
        }else {
            model.addAttribute("incidents", appFourMenuService.listByNonGarantDateDivision(user.getDivisionTitle()));
        }
        model.addAttribute("incidents", appFourMenuService.listByNonGarantDate());
        model.addAttribute("user", user);
        return "appFour60-nonGarant";
    }

}
