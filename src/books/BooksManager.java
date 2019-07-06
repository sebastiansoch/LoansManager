/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ssoch
 */
public class BooksManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File file = new File("res/loanedBooks.txt");
        BooksRepository repository = new FileRepository(file);

        BooksLister booksLister = new BooksLister(repository.prepareLoanedBooksList());
        Filter filter = null;
        
        Person person = new Person("Seba");
        filter = new PersonFilter(person);
        booksLister.addFilter(filter);
        Book book = new Book("Wedźmin");
        filter = new BookFilter(book);
        booksLister.addFilter(filter);
        booksLister.getBooks();

//        Book book = new Book("Wedźmin");
//        filter = new BookFilter(book);
//        booksLister.addFilter(filter);
//        booksLister.getBooks();
//
//        filter = new AllBooksFilter();
//        booksLister.addFilter(filter);
//        booksLister.getBooks();

    }

}
