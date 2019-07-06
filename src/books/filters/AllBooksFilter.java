/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.filters;

import books.LoanedBook;
import books.filters.Filter;

/**
 *
 * @author ssoch
 */
public class AllBooksFilter implements Filter {

    @Override
    public boolean isMeetingCriteria(LoanedBook loanedBookInfo) {
        return true;
    }
    
}
