package me.khaoula.ecom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.khaoula.ecom.entities.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
