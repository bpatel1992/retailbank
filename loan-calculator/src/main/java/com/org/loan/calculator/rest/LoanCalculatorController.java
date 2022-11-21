package com.org.loan.calculator.rest;

import com.org.loan.calculator.entity.LoanRequestForm;
import com.org.loan.calculator.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Loan calculator controller.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/loan")
public class LoanCalculatorController {

    /**
     * The Loan request service
     */
    @Autowired
    private LoanRequestService loanRequestService;

    /**
     * Get loan detail response entity.
     *
     * @param loanRequestForm the loan request form
     * @return the response entity
     */
    @PostMapping(value = "/emi/queryForm")
    public ResponseEntity getLoanDetail(@RequestBody @Valid LoanRequestForm loanRequestForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok(loanRequestService.generateEmis(loanRequestForm));
    }
}
