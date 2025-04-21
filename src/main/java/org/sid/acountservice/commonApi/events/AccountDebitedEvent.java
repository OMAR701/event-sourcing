package org.sid.acountservice.commonApi.events;

import lombok.Builder;
import lombok.Data;
import org.sid.acountservice.commonApi.enums.AccountStatus;

@Data
@Builder
public class AccountDebitedEvent extends BaseEvent<String >{

    private String currency;
    private double amount;


    public AccountDebitedEvent(String id, String currency, double amount){
        super(id);
        this.currency = currency;
        this.amount = amount;
    }
}
