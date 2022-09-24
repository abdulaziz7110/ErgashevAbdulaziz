package uz.pdp.onlineshop.dao;

import lombok.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.onlineshop.model.Maker;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MakerDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Maker> makerList(){

        String sql = "select m.id, m.name from maker m";

        return jdbcTemplate.query(sql,(rs,row)->{
            return Maker.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .country(rs.getString(3))
                    .build();
        });
    }

    public void addMaker(Maker maker){

        String sql = "insert into maker(name,description,country) values name = '"+ maker.getName() +"', description= '"+ maker.getDescription() +"', country = '"+ maker.getCountry() +"'";

        jdbcTemplate.execute(sql);

    }

    public void deleteMaker(Integer id){
        String sql = "delete from maker where id = '"+ id +"'";
        jdbcTemplate.execute(sql);
    }

    public void editMaker(Maker maker){
        String sql = "update maker set name = '"+ maker.getName() +"', description = '"+ maker.getDescription() +"','"+ maker.getCountry() +"' where id = '"+ maker.getId() +"'";
        jdbcTemplate.execute(sql);
    }
}
