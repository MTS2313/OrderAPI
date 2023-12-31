package com.msdev.order_controller_api.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Collation("product")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean enable;
    private Category category;

    private void setEnable(String enable){
        this.enable = enable == null;
    }
}
