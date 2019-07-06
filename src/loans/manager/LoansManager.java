/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager;

import books.Person;
import loans.manager.printouts.CSVPrint;
import loans.manager.printouts.Printer;
import books.filters.PersonFilter;
import java.io.File;
import java.io.IOException;
import loans.manager.repo.FileMoneyRepository;
import loans.manager.repo.Repository;

/**
 *
 * @author ssoch
 */
public class LoansManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        File file = new File("res/loanedBooks.txt");
//        Repository repository = new FileBooksRepository(file);

        File file = new File("res/loanedMoney.txt");
        Repository repository = new FileMoneyRepository(file);
        Printer printout = new CSVPrint();

        GoodsLister booksLister = new GoodsLister(repository.prepareLoanedGoodsList(), printout);
        Filter filter = null;

        money.Person person = new money.Person("Seba");
        filter = new money.PersonFilter(person);
        booksLister.addFilter(filter);
//        Book book = new Book("Wedźmin");
//        filter = new BookFilter(book);
//        booksLister.addFilter(filter);
        booksLister.getBooks();

    }

}
