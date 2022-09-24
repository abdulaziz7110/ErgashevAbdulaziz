package uz.pdp.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Category category;
    private Maker maker;
}
