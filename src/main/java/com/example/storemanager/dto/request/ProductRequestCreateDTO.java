package com.example.storemanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class ProductRequestCreateDTO {
    private String Name;
    private int Price;
    private String Amount;
}
