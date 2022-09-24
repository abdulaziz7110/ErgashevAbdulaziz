package uz.pdp.onlineshop.dao;

import lombok.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.onlineshop.model.Category;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Category> categoryList(){

        String sql = "select c.id, c.name from category c";

        return jdbcTemplate.query(sql,(rs,row)->{
            return Category.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .build();
        });
    }

    public void addCategory(Category category){

        String sql = "insert into category(name,description) values name = '"+ category.getName() +"', description= '"+ category.getDescription() +"'";

        jdbcTemplate.execute(sql);

    }

    public void deleteCategory(Integer id){
        String sql = "delete from category where id = '"+ id +"'";
        jdbcTemplate.execute(sql);
    }

    public void editCategory(Category category){
        String sql = "update category set name = '"+ category.getName() +"', description = '"+ category.getDescription() +"'";
        jdbcTemplate.execute(sql);
    }
}
