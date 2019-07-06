/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager.printouts;

import books.LoanedBook;
import java.util.List;

/**
 *
 * @author ssoch
 */
public interface Printer<T> {

    public void print(List<T> filteredGoods);

   
}
