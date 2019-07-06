/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public BooksLister(List<LoanedBook> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public void listAllLoanedBooks() throws IOException {
        StringBuilder builder = getHeader();

        for (LoanedBook loanedBookInfo : loanedBooks) {
            builder.append(getPrintLine(loanedBookInfo));
        }

        System.out.println(builder);
    }

    public void getBooksForPerson(Person person) {
        StringBuilder builder = getHeader();
        for (LoanedBook loanedBookInfo : loanedBooks) {
            if (loanedBookInfo.getPerson().equals(person)) {
                builder.append(getPrintLine(loanedBookInfo));
            }
        }
        System.out.println(builder);
    }

    public void getPersonsForBook(Book book) {
        StringBuilder builder = getHeader();
        for (LoanedBook loanedBookInfo : loanedBooks) {
            if (loanedBookInfo.getBook().equals(book)) {
                builder.append(getPrintLine(loanedBookInfo));
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
}
