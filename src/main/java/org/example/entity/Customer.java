package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Customer { // this model class represent real world customer entity
    private String id;
    private String name;
    private String tel;
    private String address;


}
