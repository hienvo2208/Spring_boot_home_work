package com.example.demo.controller;

import com.example.demo.dto.ApplicantRequest;
import com.example.demo.dto.EmployerRequest;
import com.example.demo.model.Applicant;
import com.example.demo.model.Employer;
import com.example.demo.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicantController {
    @Autowired
    ApplicantRepository applicantRepository;

    @GetMapping("/applicant-list")
    public String getListEmployer(Model model) {
        model.addAttribute("applicants", applicantRepository.getListApplicant());
        return "applicant-list";
    }

    @GetMapping("/applicant-form")
    public String addApplicant(Model model) {
        model.addAttribute("applicant", new ApplicantRequest());
        return "applicant-form";
    }
//
    @PostMapping("/applicant-form")
    public String handlerApplicant(@ModelAttribute("applicantRequest") ApplicantRequest applicantRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employer-form";
        }
        int key = applicantRepository.getListApplicant().size() + 1;
        Applicant applicant = new Applicant(applicantRequest.getName(), applicantRequest.getDob(),applicantRequest.getSkill(),applicantRequest.getExperience());
        applicantRepository.addEmployer(key, applicant);
        return "redirect:/applicant-list";
    }
}
