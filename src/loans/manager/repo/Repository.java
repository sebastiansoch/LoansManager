/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager.repo;

import books.LoanedBook;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ssoch
 */
public interface Repository<T> {
    public List<T> prepareLoanedGoodsList() throws IOException;
}
