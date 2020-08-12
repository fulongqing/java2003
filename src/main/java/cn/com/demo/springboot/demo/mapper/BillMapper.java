package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.entity.Bill;
import cn.com.demo.springboot.demo.entity.BillExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BillMapper {
    @SelectProvider(type=BillSqlProvider.class, method="countByExample")
    long countByExample(BillExample example);

    @DeleteProvider(type=BillSqlProvider.class, method="deleteByExample")
    int deleteByExample(BillExample example);

    @Delete({
        "delete from smbms_bill",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into smbms_bill (id, billCode, ",
        "productName, productDesc, ",
        "productUnit, productCount, ",
        "totalPrice, isPayment, ",
        "createdBy, creationDate, ",
        "modifyBy, modifyDate, ",
        "providerId)",
        "values (#{id,jdbcType=BIGINT}, #{billcode,jdbcType=VARCHAR}, ",
        "#{productname,jdbcType=VARCHAR}, #{productdesc,jdbcType=VARCHAR}, ",
        "#{productunit,jdbcType=VARCHAR}, #{productcount,jdbcType=DECIMAL}, ",
        "#{totalprice,jdbcType=DECIMAL}, #{ispayment,jdbcType=INTEGER}, ",
        "#{createdby,jdbcType=BIGINT}, #{creationdate,jdbcType=TIMESTAMP}, ",
        "#{modifyby,jdbcType=BIGINT}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{providerid,jdbcType=INTEGER})"
    })
    int insert(Bill record);

    @InsertProvider(type=BillSqlProvider.class, method="insertSelective")
    int insertSelective(Bill record);

    @SelectProvider(type=BillSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billCode", property="billcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="productName", property="productname", jdbcType=JdbcType.VARCHAR),
        @Result(column="productDesc", property="productdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="productUnit", property="productunit", jdbcType=JdbcType.VARCHAR),
        @Result(column="productCount", property="productcount", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalPrice", property="totalprice", jdbcType=JdbcType.DECIMAL),
        @Result(column="isPayment", property="ispayment", jdbcType=JdbcType.INTEGER),
        @Result(column="createdBy", property="createdby", jdbcType=JdbcType.BIGINT),
        @Result(column="creationDate", property="creationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifyBy", property="modifyby", jdbcType=JdbcType.BIGINT),
        @Result(column="modifyDate", property="modifydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="providerId", property="providerid", jdbcType=JdbcType.INTEGER)
    })
    List<Bill> selectByExample(BillExample example);

    @Select({
        "select",
        "id, billCode, productName, productDesc, productUnit, productCount, totalPrice, ",
        "isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId",
        "from smbms_bill",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billCode", property="billcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="productName", property="productname", jdbcType=JdbcType.VARCHAR),
        @Result(column="productDesc", property="productdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="productUnit", property="productunit", jdbcType=JdbcType.VARCHAR),
        @Result(column="productCount", property="productcount", jdbcType=JdbcType.DECIMAL),
        @Result(column="totalPrice", property="totalprice", jdbcType=JdbcType.DECIMAL),
        @Result(column="isPayment", property="ispayment", jdbcType=JdbcType.INTEGER),
        @Result(column="createdBy", property="createdby", jdbcType=JdbcType.BIGINT),
        @Result(column="creationDate", property="creationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifyBy", property="modifyby", jdbcType=JdbcType.BIGINT),
        @Result(column="modifyDate", property="modifydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="providerId", property="providerid", jdbcType=JdbcType.INTEGER)
    })
    Bill selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example);

    @UpdateProvider(type=BillSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);

    @UpdateProvider(type=BillSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Bill record);

    @Update({
        "update smbms_bill",
        "set billCode = #{billcode,jdbcType=VARCHAR},",
          "productName = #{productname,jdbcType=VARCHAR},",
          "productDesc = #{productdesc,jdbcType=VARCHAR},",
          "productUnit = #{productunit,jdbcType=VARCHAR},",
          "productCount = #{productcount,jdbcType=DECIMAL},",
          "totalPrice = #{totalprice,jdbcType=DECIMAL},",
          "isPayment = #{ispayment,jdbcType=INTEGER},",
          "createdBy = #{createdby,jdbcType=BIGINT},",
          "creationDate = #{creationdate,jdbcType=TIMESTAMP},",
          "modifyBy = #{modifyby,jdbcType=BIGINT},",
          "modifyDate = #{modifydate,jdbcType=TIMESTAMP},",
          "providerId = #{providerid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Bill record);
}