package com.msdev.order_controller_api.DTO;

import com.msdev.order_controller_api.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DTOCategory {
    private String name;
    private String description;
    public DTOCategory(Category category){
        this.name = category.getName();
        this.description = category.getDescription();
    }
}
