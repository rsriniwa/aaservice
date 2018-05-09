package com.example.productapp;

import org.keycloak.adapters.springboot.KeycloakAutoConfiguration;
import org.keycloak.adapters.springboot.MultitenantConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@ImportAutoConfiguration(MultitenantConfiguration.class)
@SpringBootApplication(exclude = {KeycloakAutoConfiguration.class})
public class ProductAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductAppApplication.class, args);
    }


    @Controller
    class ProductController {
        @GetMapping(path="/products")
        public String getProducts(Model model){
            model.addAttribute("products", Arrays.asList("ipad", "iphone"));
            return "products";
        }

        @GetMapping(path="/logout")
        public String logout(HttpServletRequest request) throws ServletException {
            request.logout();
            return "/";
        }

    }

}