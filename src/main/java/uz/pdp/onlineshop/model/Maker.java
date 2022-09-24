package uz.pdp.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Maker {
    private Integer id;
    private String companyName;
    private String description;
    private String country;
}
