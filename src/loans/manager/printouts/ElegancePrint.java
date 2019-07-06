/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager.printouts;

import books.LoanedBook;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;

/**
 *
 * @author ssoch
 */
public class ElegancePrint implements Printer<LoanedBook> {

    private LocalDate date = LocalDate.now();

    public ElegancePrint() {
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
        builder.append("\t\t");
        builder.append("Osoba");
        builder.append("\t\t");
        builder.append("Data wypożyczenia");
        builder.append("\t");
        builder.append("Okres przetrzymywania");
        builder.append("\n");
        return builder;
    }

    private  StringBuilder getPrintLine(LoanedBook loanedBookInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(loanedBookInfo.getBook());
        builder.append("\t\t");
        builder.append(loanedBookInfo.getPerson());
        builder.append("\t\t");
        builder.append(loanedBookInfo.getLoanDate());
        builder.append("\t\t");
        builder.append(DAYS.between(loanedBookInfo.getLoanDate(), date));
        builder.append("\n");
        return builder;
    }


}
