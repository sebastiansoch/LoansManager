/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.IOException;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class BooksLister {

    private final List<LoanedBook> loanedBooks;
    private LocalDate date = LocalDate.now();
    private List<Filter> filters;

    public BooksLister(List<LoanedBook> loanedBooks) {
        this.loanedBooks = loanedBooks;
        filters = new ArrayList<>();
    }

    public void getBooks() {
        StringBuilder builder = getHeader();
        for (LoanedBook loanedBookInfo : loanedBooks) {
            for (Filter filter : filters) {
                if (filter.isMeetingCriteria(loanedBookInfo)) {
                    builder.append(getPrintLine(loanedBookInfo));
                }
            }
        }
        System.out.println(builder);
    }

    private StringBuilder getHeader() {
        StringBuilder builder = new StringBuilder("Lista wypożyczonych książek");
        builder.append("\n");
        builder.append("Książka");
        builder.append("\t\t");
        builder.append("Osoba");
        builder.append("\t\t");
        builder.append("Data wypożyczenia");
        builder.append("\t");
        builder.append("Okres przetrzymywania");
        builder.append("\n");
        return builder;
    }

    private StringBuilder getPrintLine(LoanedBook loanedBookInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(loanedBookInfo.getBook());
        builder.append("\t\t");
        builder.append(loanedBookInfo.getPerson());
        builder.append("\t\t");
        builder.append(loanedBookInfo.getLoanDate());
        builder.append("\t\t");
        builder.append(DAYS.between(loanedBookInfo.getLoanDate(), date));
        builder.append("\n");
        return builder;
    }

    void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}
