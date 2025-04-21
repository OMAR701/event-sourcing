package org.sid.acountservice.queries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.acountservice.commonApi.enums.AccountStatus;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Instant createdAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> transactions;

}
