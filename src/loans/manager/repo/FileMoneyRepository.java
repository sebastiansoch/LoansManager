/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans.manager.repo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import money.Loan;
import money.LoanedMoney;
import money.Person;

/**
 *
 * @author ssoch
 */
public class FileMoneyRepository implements Repository<LoanedMoney> {

    private final File moneyFile;

    public FileMoneyRepository(File moneyFile) {
        this.moneyFile = moneyFile;
    }

    @Override
    public List<LoanedMoney> prepareLoanedGoodsList() throws IOException {
        List<String> readAllLines = Files.readAllLines(moneyFile.toPath());
        List<LoanedMoney> loanedMoney = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (String line : readAllLines) {
            if (line.isEmpty()) {
                continue;
            }

            String[] split = line.split("\\|");
            loanedMoney.add(new LoanedMoney(new Person(split[0]), new Loan(Double.parseDouble(split[1])), LocalDate.parse(split[2], formatter), LocalDate.parse(split[3], formatter)));

        }
        return loanedMoney;
    }
}
