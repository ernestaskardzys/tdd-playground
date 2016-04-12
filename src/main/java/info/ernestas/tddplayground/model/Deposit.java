package info.ernestas.tddplayground.model;

import java.util.ArrayList;
import java.util.List;

public class Deposit {

    private List<DepositPart> deposit = new ArrayList<>();

    public List<DepositPart> getDeposit() {
        return deposit;
    }

    public void setDeposit(List<DepositPart> deposit) {
        this.deposit = deposit;
    }
}
