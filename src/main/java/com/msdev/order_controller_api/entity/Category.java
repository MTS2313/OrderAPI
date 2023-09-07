package com.msdev.order_controller_api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;


@Data@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;
    @Indexed(unique = true,background = true)
    private String name;
    private String description;
}
