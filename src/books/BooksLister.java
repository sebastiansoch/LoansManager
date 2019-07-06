/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import books.printouts.Printer;
import books.filters.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class BooksLister {

    private final List<LoanedBook> loanedBooks;
    
    private List<Filter> filters;
    private final Printer printout;

    public BooksLister(List<LoanedBook> loanedBooks, Printer printout) {
        this.loanedBooks = loanedBooks;
        filters = new ArrayList<>();
        this.printout = printout;
    }

    public void getBooks() {
        List<LoanedBook> filteredBooks = new ArrayList<>();
        
        for (LoanedBook loanedBookInfo : loanedBooks) {
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
