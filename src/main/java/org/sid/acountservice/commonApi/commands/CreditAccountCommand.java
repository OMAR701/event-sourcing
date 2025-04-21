package org.sid.acountservice.commonApi.commands;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class CreditAccountCommand extends  BaseCommand<String>{

    private String accoutnId;
    private String currency;
    private double amount;

    public CreditAccountCommand(String id, String currency, double amount) {
        super(id);
        this.currency = currency;
        this.amount = amount;

    }
}
