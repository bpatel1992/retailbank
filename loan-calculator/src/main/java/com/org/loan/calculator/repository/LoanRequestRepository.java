package com.org.loan.calculator.repository;

import com.org.loan.calculator.entity.LoanRequestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Loan request repository.
 */
@Repository
public interface LoanRequestRepository extends JpaRepository<LoanRequestForm, Integer> {
}
