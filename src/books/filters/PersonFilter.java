/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.filters;

import books.LoanedBook;
import books.Person;

/**
 *
 * @author ssoch
 */
public class PersonFilter implements Filter {

    private final Person person;

    public PersonFilter(Person person) {
        this.person = person;
    }
    
    @Override
    public boolean isMeetingCriteria(LoanedBook loanedBookInfo) {
        if (person.equals(loanedBookInfo.getPerson())) {
            return true;
        }
        
        return false;
    }
    
}
