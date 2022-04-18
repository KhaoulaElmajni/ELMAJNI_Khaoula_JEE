package me.khaoula.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.khaoula.ecom.entities.Category;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    private String id;
    private String nom;
    private double prix;
    private double quantity;
    private CategoryDTO categoryDTO;
}
