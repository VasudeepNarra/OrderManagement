package com.synechron.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDERS_TBL")
public class Order {
    @Id
    @GeneratedValue
    private Integer orderId;
    private String orderName;
    private Double orderAmount;
}
