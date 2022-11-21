package com.org.loan.calculator.payload.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class LoanEmiDetails {
    private float monthlyEmi;
    private float principleAmount;
    private float totalInterest;
    private float totalAmount;
}
