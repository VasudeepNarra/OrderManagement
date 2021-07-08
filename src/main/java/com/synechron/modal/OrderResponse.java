package com.synechron.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse {

    private String userName;
    private String orderName;

    public OrderResponse(String userName, String orderName) {
        this.userName = userName;
        this.orderName = orderName;
    }

    private Double orderAmount;
}