package mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mybatis.pojo.Toy;
@Repository("toyMapper")
public interface toyMapper {
 List<Toy> findByName (@Param("name") String name);
 @Select("select id,name,price,sale_date saleDate from toy where id=#{id}")
 Toy findById(Integer id);
 @Select("select id,name,price,sale_date saleDate from toy")
 List<Toy> find();
 @Delete("delete from toy where id=#{id}")
 int remove(Integer id);
 @Update("update toy set name=#{name,jdbcType=VARCHAR},price=#{price,jdbcType=DOUBLE},"
 		+ "sale_date=#{saleDate,jdbcType=DATE} where id=#{id,jdbcType=INTEGER}")
 int modify(Toy to);
 @Insert("insert into toy(id,name,price,sale_date) values(#{id},#{name},#{price},#{saleDate})")
 @SelectKey(keyProperty="id",statement="select seq_crm.nextval from dual",
 resultType= int.class,before=true)
 int addtoy(Toy to);
}
