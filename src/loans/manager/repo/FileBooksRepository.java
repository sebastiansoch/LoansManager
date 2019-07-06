/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager.repo;

import books.Book;
import books.LoanedBook;
import books.Person;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class FileBooksRepository implements Repository<LoanedBook> {

    private final File booksFile;

    public FileBooksRepository(File booksFile) {
        this.booksFile = booksFile;
    }

    @Override
    public List<LoanedBook> prepareLoanedGoodsList() throws IOException {
        List<String> readAllLines = Files.readAllLines(booksFile.toPath());
        List<LoanedBook> loanedBooks = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (String line : readAllLines) {
            if (line.isEmpty()) {
                continue;
            }
            
            String[] split = line.split("\\|");
            loanedBooks.add(new LoanedBook(new Book(split[0]), new Person(split[1]), LocalDate.parse(split[2], formatter)));
        }
        return loanedBooks;
    }

}
