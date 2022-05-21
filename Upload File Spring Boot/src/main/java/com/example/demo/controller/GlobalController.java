package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalController {
     public String handleStorageFileNotFound(MaxUploadSizeExceededException e, Model model){
         model.addAttribute("errorMessage", "File is to large. Detail: "+e.getMessage());
         return "failure";
     }
}
