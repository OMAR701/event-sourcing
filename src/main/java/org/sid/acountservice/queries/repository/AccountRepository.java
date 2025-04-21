package org.sid.acountservice.queries.repository;

import org.sid.acountservice.queries.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
