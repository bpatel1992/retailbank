package com.org.loan.calculator.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(maxAge = 3600)
@Controller
public class ViewController {

    @RequestMapping("/")
    public ModelAndView viewPage(){
        ModelAndView modelAndView =  new ModelAndView("welcome");
        return modelAndView;
    }

    @RequestMapping("/loan")
    public ModelAndView viewMain(){
        ModelAndView modelAndView =  new ModelAndView("loanCalculation");
        return modelAndView;
    }
}
