package com.example.Monitoring.controller;

import com.example.Monitoring.service.AppFourTableService;
import com.example.Monitoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
@Controller
@RequiredArgsConstructor
public class AppFourTableController {
    private final UserService userService;
    private final AppFourTableService appFourTableService;


    @GetMapping("/appFourTable")
    public String appFourTable(Principal principal, Model model){
        model.addAttribute("fourTables", appFourTableService.tableList());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "/appFourTable";
    }

}
