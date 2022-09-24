package uz.pdp.onlineshop.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.onlineshop.model.Product;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Product> getAllProduct(){

        String sql = "";

        jdbcTemplate.query(sql,(rs,row)->{

        });

    }
}
