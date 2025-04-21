package org.sid.acountservice.commonApi.events;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.sid.acountservice.commonApi.enums.AccountStatus;

@Data
@Builder
public class AccountCreatedEvent extends BaseEvent<String >{

    private String currency;
    private double balance;

    private AccountStatus accountStatus;

    public AccountCreatedEvent(String id, String currency, double balance, AccountStatus accountStatus){
        super(id);
        this.currency = currency;
        this.balance = balance;
        this.accountStatus = accountStatus;
    }
}
