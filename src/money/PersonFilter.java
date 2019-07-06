/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money;

import loans.manager.Filter;
import money.LoanedMoney;
import money.Person;

/**
 *
 * @author ssoch
 */
public class PersonFilter implements Filter<LoanedMoney> {

    private final Person person;

    public PersonFilter(Person person) {
        this.person = person;
    }
    
    @Override
    public boolean isMeetingCriteria(LoanedMoney loanedBookInfo) {
        if (person.equals(loanedBookInfo.getPerson())) {
            return true;
        }
        
        return false;
    }
}
