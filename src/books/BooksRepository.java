/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ssoch
 */
interface BooksRepository {
    public List<LoanedBook> prepareLoanedBooksList() throws IOException;
}
