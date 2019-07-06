/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money.printouts;


import loans.manager.Printer;
import java.time.LocalDate;
import java.util.List;
import money.LoanedMoney;

/**
 *
 * @author ssoch
 */
public class ElegancePrint implements Printer<LoanedMoney> {

    private LocalDate date = LocalDate.now();

    public ElegancePrint() {
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
        builder.append("\t\t");
        builder.append("Kwota");
        builder.append("\t\t");
        builder.append("Data pożyczki");
        builder.append("\t");
        builder.append("Data zwrotu");
        builder.append("\n");
        return builder;
    }

    private  StringBuilder getPrintLine(LoanedMoney loanedMoneyInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(loanedMoneyInfo.getPerson());
        builder.append("\t\t");
        builder.append(loanedMoneyInfo.getLoanAmount());
        builder.append("\t\t");
        builder.append(loanedMoneyInfo.getLoanDate());
        builder.append("\t\t");
        builder.append(loanedMoneyInfo.getPlannedReturnigDate());
        builder.append("\n");
        return builder;
    }


}
