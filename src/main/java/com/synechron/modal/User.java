package com.synechron.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="USERS_TBL")
public class User {
    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String userPassword;
    private String email;
    private String phoneNumber;

    /*@JsonIgnore
    @OneToMany(mappedBy = "user", cascade={CascadeType.ALL})*/

    @OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="userorder_fk",referencedColumnName = "userId")
    private List<Order> orders;
}
