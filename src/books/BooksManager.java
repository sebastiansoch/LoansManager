/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
        BooksLister  booksLister = new BooksLister(file);
        
        booksLister.listAllLoanedBooks();

    }
    
    
}
