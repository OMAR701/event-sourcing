package org.sid.acountservice.commands.aggregates;


import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.acountservice.commonApi.commands.CreateAccountCommand;
import org.sid.acountservice.commonApi.commands.CreditAccountCommand;
import org.sid.acountservice.commonApi.commands.DebitAccountCommand;
import org.sid.acountservice.commonApi.enums.AccountStatus;
import org.sid.acountservice.commonApi.events.AccountCreatedEvent;
import org.sid.acountservice.commonApi.events.AccountCreditedEvent;
import org.sid.acountservice.commonApi.events.AccountDebitedEvent;
import org.sid.acountservice.commonApi.exceptions.NegativeInitialBalanceException;
import org.springframework.context.event.EventListener;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String accountId;

    private String currency;
    private double balance;
    private AccountStatus accountStatus;

    public AccountAggregate(){

    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){

        if (createAccountCommand.getInitialBalance() < 0) throw new NegativeInitialBalanceException("Negative Balance");

        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getCurrency(),
                createAccountCommand.getInitialBalance(),
                AccountStatus.ACTIVATED
        ));
    }


    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.accountId = event.getId();
        this.currency = event.getCurrency();
        this.accountStatus = event.getAccountStatus();
        this.balance = event.getBalance();
    }

    @CommandHandler
    public void handle(CreditAccountCommand command){
        if (command.getAmount() < 0) throw new NegativeInitialBalanceException("Negative Amount");
        AggregateLifecycle.apply(
                new AccountCreditedEvent(
                        command.getId(),
                        command.getCurrency(),
                        command.getAmount()
                )
        );
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event){
        this.balance  += event.getAmount();
    }

    @CommandHandler
    public void handle(DebitAccountCommand command){
        if (command.getAmount() < 0) throw new NegativeInitialBalanceException("Negative Amount");
        if (command.getAmount() > this.balance) throw new NegativeInitialBalanceException("Sold Insufficient ");

        AggregateLifecycle.apply(
                new AccountDebitedEvent(
                        command.getId(),
                        command.getCurrency(),
                        command.getAmount()
                )
        );
    }

    @EventSourcingHandler
    public void on(DebitAccountCommand event){
        this.balance  -= event.getAmount();
    }

}
