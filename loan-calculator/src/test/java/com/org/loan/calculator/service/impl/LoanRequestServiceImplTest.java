package com.org.loan.calculator.service.impl;

import com.org.loan.calculator.BaseTest;
import com.org.loan.calculator.entity.LoanRequestForm;
import com.org.loan.calculator.payload.response.LoanEmiDetails;
import com.org.loan.calculator.repository.LoanRequestRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanRequestServiceImplTest extends BaseTest {
    @InjectMocks
    private LoanRequestServiceImpl loanRequestService =  new LoanRequestServiceImpl();

    @Mock
    LoanRequestRepository loanRequestRepository;

//    @Test
//    void testGenerateEmis() {
//        LoanRequestForm loanRequestForm = new LoanRequestForm();
//        loanRequestForm.setLoanAmount(100000);
//        loanRequestForm.setInterest(6);
//        loanRequestForm.setTenue(24);
//        loanRequestForm.setRepaymentAmount(250000);
//           LoanEmiDetails loanEmiDetails = new  LoanEmiDetails();
//           loanEmiDetails.setMonthlyEmi(4432);
//           loanEmiDetails.setTotalInterest(6370);
//           loanEmiDetails.setTotalAmount(106370);
//           loanEmiDetails.setPrincipleAmount(100000);
//        Mockito.when(loanRequestService.generateEmis(loanRequestForm)).thenReturn(loanEmiDetails);
//        loanRequestService.generateEmis(loanRequestForm);
//    }

    @Test
    void testGenerateEmis2() {
        LoanRequestForm loanRequestForm = new LoanRequestForm();
        loanRequestForm.setId(1);
        loanRequestForm.setInterest(10.0f);
        loanRequestForm.setLoanAmount(10.0f);
        loanRequestForm.setRepaymentAmount(10.0f);
        loanRequestForm.setTenue(1);
        LoanEmiDetails actualGenerateEmisResult = loanRequestService.generateEmis(loanRequestForm);
        Assert.assertEquals(10.0f, actualGenerateEmisResult.getMonthlyEmi());
        Assert.assertEquals(0.0f, actualGenerateEmisResult.getTotalInterest());
        Assert.assertEquals(10.0f, actualGenerateEmisResult.getTotalAmount());
        Assert.assertEquals(10.0f, actualGenerateEmisResult.getPrincipleAmount());
    }


    @Test
    void testGenerateEmis3() {
        LoanRequestForm loanRequestForm = Mockito.mock(LoanRequestForm.class);
        Mockito.when(loanRequestForm.getInterest()).thenReturn(10.0f);
        Mockito.when(loanRequestForm.getLoanAmount()).thenReturn(10.0f);
        Mockito.when(loanRequestForm.getTenue()).thenReturn(1);
        Mockito.doNothing().when(loanRequestForm).setId((Integer) Mockito.any());
        Mockito.doNothing().when(loanRequestForm).setInterest(Mockito.anyFloat());
        Mockito.doNothing().when(loanRequestForm).setLoanAmount(Mockito.anyFloat());
        Mockito.doNothing().when(loanRequestForm).setRepaymentAmount(Mockito.anyFloat());
        Mockito.doNothing().when(loanRequestForm).setTenue((Integer) Mockito.any());
        loanRequestForm.setId(1);
        loanRequestForm.setInterest(10.0f);
        loanRequestForm.setLoanAmount(10.0f);
        loanRequestForm.setRepaymentAmount(10.0f);
        loanRequestForm.setTenue(1);
        LoanEmiDetails actualGenerateEmisResult = loanRequestService.generateEmis(loanRequestForm);
        Assert.assertEquals(10.0f, actualGenerateEmisResult.getMonthlyEmi());
        Assert.assertEquals(0.0f, actualGenerateEmisResult.getTotalInterest());
        Assert.assertEquals(10.0f, actualGenerateEmisResult.getTotalAmount());
        Assert.assertEquals(10.0f, actualGenerateEmisResult.getPrincipleAmount());
        Mockito.verify(loanRequestForm).getInterest();
        Mockito.verify(loanRequestForm).getLoanAmount();
        Mockito.verify(loanRequestForm).getTenue();
        Mockito.verify(loanRequestForm).setId((Integer) Mockito.any());
        Mockito.verify(loanRequestForm).setInterest(Mockito.anyFloat());
        Mockito.verify(loanRequestForm).setLoanAmount(Mockito.anyFloat());
        Mockito.verify(loanRequestForm).setRepaymentAmount(Mockito.anyFloat());
        Mockito.verify(loanRequestForm).setTenue((Integer) Mockito.any());
    }
}

