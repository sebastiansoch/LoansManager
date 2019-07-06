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

    private final File booksFile;

    public BooksLister(File booksFile) {
        this.booksFile = booksFile;
    }

    public void listAllLoanedBooks() throws IOException {
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
        LocalDate date = LocalDate.now();

        for (LoanedBook book : prepareLoanedBooksList()) {
            builder.append(book.getBook());
            builder.append("\t\t");
            builder.append(book.getPerson());
            builder.append("\t\t");
            builder.append(book.getLoanDate());
            builder.append("\t\t");
            builder.append(DAYS.between(book.getLoanDate(), date));
            builder.append("\n");
        }
        
        System.out.println(builder);
    }

    private List<LoanedBook> prepareLoanedBooksList() throws IOException {
        List<String> readAllLines = Files.readAllLines(booksFile.toPath());
        List<LoanedBook> loanedBooks = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (String line : readAllLines) {
            String[] split = line.split("\\|");
            loanedBooks.add(new LoanedBook(new Book(split[0]), new Person(split[1]), LocalDate.parse(split[2], formatter)));
        }
        return loanedBooks;
    }

}
