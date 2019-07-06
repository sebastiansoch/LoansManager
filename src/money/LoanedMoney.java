/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money;

import java.time.LocalDate;

/**
 *
 * @author ssoch
 */
public class LoanedMoney {
    private final Person person;
    private final Loan loanAmount;
    private final LocalDate loanDate;
    private final LocalDate plannedReturnigDate;

    public LoanedMoney(Person person, Loan loanAmount, LocalDate loanDate, LocalDate plannedReturnigDate) {
        this.person = person;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.plannedReturnigDate = plannedReturnigDate;
    }

    public Person getPerson() {
        return person;
    }

    public Loan getLoanAmount() {
        return loanAmount;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getPlannedReturnigDate() {
        return plannedReturnigDate;
    }
    
    
}
