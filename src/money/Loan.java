/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money;

/**
 *
 * @author ssoch
 */
public class Loan {
    private Double amount;

    public Loan(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
