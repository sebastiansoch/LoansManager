/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.printouts;

import books.LoanedBook;
import java.util.List;

/**
 *
 * @author ssoch
 */
public interface Printer {

    public void print(List<LoanedBook> filteredBooks);

   
}
