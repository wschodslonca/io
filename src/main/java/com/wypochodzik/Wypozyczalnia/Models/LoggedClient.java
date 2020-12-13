package com.wypochodzik.Wypozyczalnia.Models;

import com.wypochodzik.Wypozyczalnia.Models.LoggedSession.*;
import org.springframework.stereotype.Component;

@Component
public class LoggedClient {
    private final CarBrowseL carBrowseL;
    private final EditAccount editAccount;
    private final EditOrder editOrder;
    private final MakeOrder makeOrder;
    private final Pay pay;

    public LoggedClient(CarBrowseL carBrowseL, EditAccount editAccount, EditOrder editOrder, MakeOrder makeOrder, Pay pay) {
        this.carBrowseL = carBrowseL;
        this.editAccount = editAccount;
        this.editOrder = editOrder;
        this.makeOrder = makeOrder;
        this.pay = pay;
    }
}
