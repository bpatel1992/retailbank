package com.org.loan.calculator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_loan_request")
@Data
public class LoanRequestForm {

    @Id
    private Integer id;
    @NotNull(message = "Loan amount should not be empty")
    private float loanAmount;
    @NotNull(message = "repayment amount should not be empty")
    private float repaymentAmount;
    @NotNull(message = "Loan interest should not be empty")
    private float interest;
    @NotNull(message = "Loan tenue should not be empty")
    private Integer tenue;
}
