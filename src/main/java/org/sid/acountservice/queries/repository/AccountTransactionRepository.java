package org.sid.acountservice.queries.repository;

import org.sid.acountservice.queries.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {
}
