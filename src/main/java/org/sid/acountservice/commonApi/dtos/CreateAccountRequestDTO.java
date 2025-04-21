package org.sid.acountservice.commonApi.dtos;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountRequestDTO {
    @Getter private  String currency;
    @Getter private double initialBalance;
}
