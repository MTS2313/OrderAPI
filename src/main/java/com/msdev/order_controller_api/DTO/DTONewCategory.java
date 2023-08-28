package com.msdev.order_controller_api.DTO;

import com.msdev.order_controller_api.entity.Category;

public record DTONewCategory(Category newCategory, String message) {
}
