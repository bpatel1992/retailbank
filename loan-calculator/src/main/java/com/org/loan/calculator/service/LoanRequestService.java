package com.org.loan.calculator.service;

import com.org.loan.calculator.entity.LoanRequestForm;
import com.org.loan.calculator.payload.response.LoanEmiDetails;

/**
 * The interface Loan request service.
 */
public interface LoanRequestService {

    /**
     * Generate emis list.
     *
     * @param loanRequestForm the loan request form
     * @return the list
     */
    LoanEmiDetails generateEmis(LoanRequestForm loanRequestForm);
}
