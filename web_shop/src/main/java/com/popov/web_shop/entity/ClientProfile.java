package com.popov.web_shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class ClientProfile {
    @Id
    @OneToOne
    private Client id;

    private String firstName;
    private String lastName;
    private String secondName;
}
