package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.TravelType;
import com.example.demo.repository.InMemoryRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Controller
public class HomeController {

    @Autowired
    InMemoryRepository inMemoryRepository;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/text")
    public String demoText(Model model) throws ParseException {
        Person tom = new Person("Tom", "USA", new SimpleDateFormat("yyyy-MM-dd").parse("1999-22-08"), "male");
        model.addAttribute("person", tom);
        model.addAttribute("message", "<h2> Hachiko <span style ='color:red'> HTML </span> inside</h2>");
        return "text";
    }

    @GetMapping("/link")
    public String linkExpression(Model model) {
        model.addAttribute("dynamiclink", "products");
        return "link";
    }

    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello")
    public String sayHello(Model model) {
        return "hello";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        return "about";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", inMemoryRepository.getProducts());
        return "products";
    }

    @GetMapping("/condition")
    public String demoCondition(Model model){
        model.addAttribute("people",inMemoryRepository.getPeople());
        return "people";
    }

    @GetMapping("/switch")
    public String demoSwitch(Model model){
        model.addAttribute("users",inMemoryRepository.getUsers());
        return "switch";
    }

    @GetMapping("/thblock")
    public String demoThBlock(Model model){
        model.addAttribute("travelTypes", TravelType.values());
        return "thblock";
    }

}
