/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.printouts;

import books.LoanedBook;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class CSVPrint implements Printer {
private LocalDate date = LocalDate.now();
    public CSVPrint() {
    }

    @Override
    public void print(List<LoanedBook> filteredBooks) {
        StringBuilder builder = getHeader();
        for (LoanedBook loanedBookInfo : filteredBooks) {
            builder.append(getPrintLine(loanedBookInfo));
        }
        System.out.println(builder);
    }
 
    
        private  StringBuilder getHeader() {
        StringBuilder builder = new StringBuilder("Lista wypożyczonych książek");
        builder.append("\n");
        builder.append("Książka");
        builder.append(";");
        builder.append("Osoba");
        builder.append(";");
        builder.append("Data wypożyczenia");
        builder.append(";");
        builder.append("Okres przetrzymywania");
        builder.append("\n");
        return builder;
    }

    private  StringBuilder getPrintLine(LoanedBook loanedBookInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(loanedBookInfo.getBook());
        builder.append(";");
        builder.append(loanedBookInfo.getPerson());
        builder.append(";");
        builder.append(loanedBookInfo.getLoanDate());
        builder.append(";");
        builder.append(DAYS.between(loanedBookInfo.getLoanDate(), date));
        builder.append("\n");
        return builder;
    }

}
