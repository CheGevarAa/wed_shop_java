package com.popov.web_shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class ModelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long someone_id

    private String colour;
    private Long price;
    private Long amount;
}
