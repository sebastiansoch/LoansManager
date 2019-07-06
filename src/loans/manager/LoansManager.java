/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager;

import books.Book;
import books.BooksLister;
import books.Person;
import books.repo.FileRepository;
import books.repo.BooksRepository;
import books.printouts.CSVPrint;
import books.printouts.Printer;
import books.filters.BookFilter;
import books.filters.Filter;
import books.filters.PersonFilter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ssoch
 */
public class LoansManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("res/loanedBooks.txt");
        BooksRepository repository = new FileRepository(file);

//        Printer printout = new ElegancePrint();
        Printer printout = new CSVPrint();
       
        BooksLister booksLister = new BooksLister(repository.prepareLoanedBooksList(), printout);
        Filter filter = null;
        
        Person person = new Person("Seba");
        filter = new PersonFilter(person);
        booksLister.addFilter(filter);
        Book book = new Book("Wedźmin");
        filter = new BookFilter(book);
        booksLister.addFilter(filter);
        booksLister.getBooks();

        

    }

}
