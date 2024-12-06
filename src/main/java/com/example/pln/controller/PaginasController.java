package com.example.pln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {
    
    @GetMapping(value ="/alumnosAdmin")
    public String alumnosAdmin(){
    
        return "alumnosAdmin";
    
    }
     @GetMapping(value ="/generosAdmin")
    public String generosAdmin(){
    
        return "generosAdmin";
    
    }
    @GetMapping(value ="/gruposAdmin")
    public String gruposAdmin(){
    
        return "gruposAdmin";
    
    }
}
