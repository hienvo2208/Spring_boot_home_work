package com.example.demo.controller;

import com.example.demo.dto.EmployerRequest;
import com.example.demo.model.Employer;
import com.example.demo.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping("/employer-list")
    public String getListEmployer(Model model) {
        model.addAttribute("employers", employerRepository.getListEmployer());
        return "employer-list";
    }

    @GetMapping("/employer-form")
    public String addEmployer(Model model) {
        model.addAttribute("employerRequest", new EmployerRequest());
        return "employer-form";
    }

    @PostMapping("/employer-form")
    public String handlerAddEmployer(@ModelAttribute("employerRequest") EmployerRequest employerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employer-form";
        }
        int key = employerRepository.getListEmployer().size() + 1;
        Employer employer = new Employer(employerRequest.getName(), employerRequest.getAddress());
        employerRepository.addEmployer(key, employer);
        return "redirect:/employer-list";
    }
}
