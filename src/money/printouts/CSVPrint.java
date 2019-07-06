/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money.printouts;

import loans.manager.Printer;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;
import money.LoanedMoney;

/**
 *
 * @author ssoch
 */
public class CSVPrint implements Printer<LoanedMoney> {
private LocalDate date = LocalDate.now();
    public CSVPrint() {
    }

    @Override
    public void print(List<LoanedMoney> filteredMoney) {
        StringBuilder builder = getHeader();
        for (LoanedMoney loanedMoneyInfo : filteredMoney) {
            builder.append(getPrintLine(loanedMoneyInfo));
        }
        System.out.println(builder);
    }
 
    
        private  StringBuilder getHeader() {
        StringBuilder builder = new StringBuilder("Lista dłużników");
        builder.append("\n");
        builder.append("Osoba");
        builder.append(";");
        builder.append("Kwota");
        builder.append(";");
        builder.append("Data pożyczki");
        builder.append(";");
        builder.append("Data zwrotu");
        builder.append("\n");
        return builder;
    }

    private  StringBuilder getPrintLine(LoanedMoney loanedMoneyInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(loanedMoneyInfo.getPerson());
        builder.append(";");
        builder.append(loanedMoneyInfo.getLoanAmount());
        builder.append(";");
        builder.append(loanedMoneyInfo.getLoanDate());
        builder.append(";");
        builder.append(loanedMoneyInfo.getPlannedReturnigDate());
        builder.append("\n");
        return builder;
    }

}
