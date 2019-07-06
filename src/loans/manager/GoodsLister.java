/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager;

import books.LoanedBook;
import loans.manager.printouts.Printer;
import loans.manager.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class GoodsLister<T> {

    private final List<T> loanedBooks;
    
    private List<Filter> filters;
    private final Printer printout;

    public GoodsLister(List<T> loanedBooks, Printer printout) {
        this.loanedBooks = loanedBooks;
        filters = new ArrayList<>();
        this.printout = printout;
    }

    public void getBooks() {
        List<T> filteredBooks = new ArrayList<>();
        
        for (T loanedBookInfo : loanedBooks) {
            for (Filter filter : filters) {
                if (filter.isMeetingCriteria(loanedBookInfo)) {
                    filteredBooks.add(loanedBookInfo);
                }
            }
        }
        
        printout.print(filteredBooks);
    }



    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}
