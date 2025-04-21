package org.sid.acountservice.commonApi.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditAccountRequestDTO {
    @Getter private String accountId;
    @Getter private  String currency;
    @Getter private double amount;
}
