/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.time.LocalDate;

/**
 *
 * @author ssoch
 */
public class LoanedBook {
    private Book book;
    private Person person;
    private LocalDate loanDate;

    public LoanedBook(Book book, Person person, LocalDate loanDate) {
        this.book = book;
        this.person = person;
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
}
