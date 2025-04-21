package org.sid.acountservice.commonApi.events;

import lombok.Builder;
import lombok.Data;
import org.sid.acountservice.commonApi.enums.AccountStatus;

@Data
@Builder
public class AccountCreditedEvent extends BaseEvent<String >{

    private String accountId;
    private double amount;
    private String currency;


    public AccountCreditedEvent(String id, String currency, double amount){
        super(id);
        this.currency = currency;
        this.amount = amount;
    }
}
