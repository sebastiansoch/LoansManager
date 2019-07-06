/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money;

import loans.manager.printouts.Printer;
import java.util.ArrayList;
import java.util.List;
import loans.manager.Filter;

/**
 *
 * @author ssoch
 */
public class MoneyLister {

    private final List<LoanedMoney> loanedMoney;
    
    private List<Filter> filters;
    private final Printer printout;

    public MoneyLister(List<LoanedMoney> loanedMoney, Printer printout) {
        this.loanedMoney = loanedMoney;
        filters = new ArrayList<>();
        this.printout = printout;
    }

    public void getMoney() {
        List<LoanedMoney> filteredMoney = new ArrayList<>();
        
        for (LoanedMoney loanedMoneyInfo : loanedMoney) {
            for (Filter filter : filters) {
                if (filter.isMeetingCriteria(loanedMoneyInfo)) {
                    filteredMoney.add(loanedMoneyInfo);
                }
            }
        }
        
        printout.print(filteredMoney);
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}
