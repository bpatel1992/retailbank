package com.org.loan.calculator.service.impl;

import com.org.loan.calculator.entity.LoanRequestForm;
import com.org.loan.calculator.payload.response.LoanEmiDetails;
import com.org.loan.calculator.repository.LoanRequestRepository;
import com.org.loan.calculator.service.LoanRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Loan request service.
 */
@Service
@Slf4j
public class LoanRequestServiceImpl implements LoanRequestService {

    /**
     * The Loan request repository
     */
    @Autowired
    private LoanRequestRepository loanRequestRepository;
    /**
     * Generate emis list.
     *
     * @param loanRequestForm the loan request form
     * @return the list
     */
    @Override
    public LoanEmiDetails generateEmis(LoanRequestForm loanRequestForm) {
        float rate =  loanRequestForm.getInterest();
        int duration = loanRequestForm.getTenue();
        float principleAmount =  loanRequestForm.getLoanAmount();
        float monthlyEmi;
        rate =  rate / (12 * 100);
        monthlyEmi = (principleAmount * rate * (float)Math.pow(1 + rate, duration))
                / (float)(Math.pow(1 + rate, duration) - 1);
        LoanEmiDetails loanEmiDetails =  new LoanEmiDetails();
        float totalAmount = monthlyEmi * duration;
        loanEmiDetails.setMonthlyEmi(Math.round(monthlyEmi));
        loanEmiDetails.setTotalAmount(Math.round(totalAmount));
        loanEmiDetails.setTotalInterest(Math.round(totalAmount) -  Math.round(principleAmount));
        loanEmiDetails.setPrincipleAmount(Math.round(principleAmount));
        return loanEmiDetails;
    }
}
