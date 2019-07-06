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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class FileRepository implements BooksRepository {

    private final File booksFile;

    public FileRepository(File booksFile) {
        this.booksFile = booksFile;
    }

    @Override
    public List<LoanedBook> prepareLoanedBooksList() throws IOException {
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
