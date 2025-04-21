package org.sid.acountservice.queries.service;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.sid.acountservice.commonApi.events.AccountCreatedEvent;
import org.sid.acountservice.commonApi.events.AccountCreditedEvent;
import org.sid.acountservice.queries.entity.Account;
import org.sid.acountservice.queries.repository.AccountRepository;
import org.sid.acountservice.queries.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountEventHandlerService {

    private AccountRepository accountRepository;
    private AccountTransactionRepository accountTransactionRepository;

    public AccountEventHandlerService(AccountRepository accountRepository, AccountTransactionRepository accountTransactionRepository) {
        this.accountRepository = accountRepository;
        this.accountTransactionRepository = accountTransactionRepository;
    }


    @EventHandler
    public void on(AccountCreatedEvent event, EventMessage<AccountCreatedEvent> eventEventMessage){

        log.info("*************");
        log.info("account received");
        Account account = new Account();
        account.setId(event.getId());
        account.setBalance(event.getBalance());
        account.setCurrency(event.getCurrency());
        account.setAccountStatus(event.getAccountStatus());
        account.setCreatedAt(eventEventMessage.getTimestamp());
        accountRepository.save(account);
    }
}
