package com.example.Monitoring.controller;

import com.example.Monitoring.model.Division;
import com.example.Monitoring.model.Product;
import com.example.Monitoring.model.Regiment;
import com.example.Monitoring.model.User;
import com.example.Monitoring.service.DivisionService;
import com.example.Monitoring.service.ProductService;
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
import java.sql.Date;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final UserService userService;
    private final ProductService productService;
    private final RegimentService regimentService;

    @GetMapping("/products")
    public String products(@RequestParam(name = "searchWord", required = false) String title,
                           Principal principal, Model model) {
        User user = userService.getUserByPrincipal(principal);
        String divisionTitle = user.getDivisionTitle();
        if(user.isAdmin()) {
            model.addAttribute("products", productService.list(title));
        }else {
            model.addAttribute("products", productService.listByDivision(title, divisionTitle));
        }
        model.addAttribute("user", user);
        model.addAttribute("searchWord", title);
        return "products";
    }

    @PostMapping("products/add")
    public String add(@RequestParam("serialNumber") String serialNumber,
                      @RequestParam("modelOfTechnical") String modelOfTechnical,
                      @RequestParam("regiment") String regiment,
                      @RequestParam("dateOfProduction") Date dateSQL,
                      Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        Regiment regimentEntity = regimentService.findByTitle(regiment);
        if (regimentEntity.getDivision().getTitle().equals(user.getDivisionTitle()) || user.isAdmin()) {
            Product product = new Product();
            LocalDateTime date = dateSQL.toLocalDate().atTime(12, 0);
            productService.correct(product, serialNumber, modelOfTechnical, regiment, date);
        }
        return "redirect:/products";
    }

    @GetMapping("products/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        Product product = productService.findById(id);
        String divisionTitle=product.getRegiment().getDivision().getTitle();
        if (divisionTitle.equals(user.getDivisionTitle()) || user.isAdmin()) {
            model.addAttribute("product", product);
            model.addAttribute("user", userService.getUserByPrincipal(principal));
        }
        return "product-edit";
    }

    @PostMapping("products/edit/product-edit/{id}")
    public String edit(@RequestParam("serialNumber") String serialNumber,
                       @RequestParam("modelOfTechnical") String modelOfTechnical,
                       @RequestParam("regiment") String regiment,
                       @RequestParam("dateOfProduction") Date dateSQL,
                       @PathVariable("id") Long id,
                       Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        Product product = productService.findById(id);
        String divisionTitle=product.getRegiment().getDivision().getTitle();
        if (divisionTitle.equals(user.getDivisionTitle()) || user.isAdmin()) {
            LocalDateTime date = dateSQL.toLocalDate().atTime(12, 0);
            productService.correct(product, serialNumber, modelOfTechnical, regiment, date);
        }
        return "redirect:/products";
    }

    @GetMapping("product/delete/{id}")
    public String delete(@PathVariable("id")Long id, Principal principal){
        User user = userService.getUserByPrincipal(principal);
        Product product = productService.findById(id);
        String divisionTitle=product.getRegiment().getDivision().getTitle();
        if (divisionTitle.equals(user.getDivisionTitle()) || user.isAdmin()) {
            productService.delete(id);
        }
        return "redirect:/products";
    }

}

