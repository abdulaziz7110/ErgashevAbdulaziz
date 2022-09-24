package uz.pdp.onlineshop.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.onlineshop.model.Category;
import uz.pdp.onlineshop.model.Maker;
import uz.pdp.onlineshop.model.Product;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Product> getAllProduct(){

        String sql = "select p.id,p.name,p.price,c.id,c.name,m.id,m.name from product p\n" +
                "join category c on c.id = p.category_id\n" +
                "join maker m on m.id = p.\"maker_id \"";

        return jdbcTemplate.query(sql,(rs,row)->{
            return Product.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .price(rs.getDouble(3))
                    .category(Category.builder()
                            .id(rs.getInt(4))
                            .name(rs.getString(5))
                            .build())
                    .maker(Maker.builder()
                            .id(rs.getInt(6))
                            .name(rs.getString(7))
                            .build())
                    .build();
        });

    }

    public boolean saveProduct(Product product){

        String sql = "insert into product(name,price,description,category_id,maker_id) " +
                "values name = '"+ product.getName() +"', price = '"+ product.getPrice() +"' ";

        return jdbcTemplate.update(sql) > 0;
    }

    public boolean deleteProduct(Integer id){

        String sql = "delete from product where id = '"+ id +"'";

        return jdbcTemplate.update(sql) > 0;

    }

    public boolean editProduct(Product product){

        String sql = "update product set id = '"+ product.getId() +"', name = '"+ product.getName() +"'," +
                " price = '"+ product.getPrice() +"', category_id = '"+ product.getCategoryId() +"',maker_id = '"+ product.getMakerId() +"'" +
                "where id = '"+ product.getId() +"'";

        return jdbcTemplate.update(sql)>0;

    }
}
