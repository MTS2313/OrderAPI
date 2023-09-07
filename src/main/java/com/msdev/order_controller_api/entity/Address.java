package com.msdev.order_controller_api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private String id;
    @Indexed(name = "User_Email",unique = true)
    private String user;
    private List<BuildAddress> address;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class BuildAddress{
    private String country;
    private String city;
    private String state;
    private String lineOne;
    private String lineTwo;
    private String postalCode;
    private String ReferencePoint;
}
