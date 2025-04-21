package org.sid.acountservice.commonApi.commands;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.sid.acountservice.commonApi.enums.AccountStatus;


@Data
@Builder
public class DebitAccountCommand extends  BaseCommand<String>{

    private String currency;
    private double amount;

    public DebitAccountCommand(String id,String currency, double amount) {
        super(id);
        this.currency = currency;
        this.amount = amount;

    }
}
