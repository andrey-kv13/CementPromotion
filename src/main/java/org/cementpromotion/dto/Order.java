package org.cementpromotion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Order {
    private String customer;
    private double kg;
    private LocalDateTime date;
    private double finalPrice;
}

