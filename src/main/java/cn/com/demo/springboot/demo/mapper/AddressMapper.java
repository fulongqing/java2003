package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.entity.Address;
import cn.com.demo.springboot.demo.entity.AddressExample;
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

public interface AddressMapper {
    @SelectProvider(type=AddressSqlProvider.class, method="countByExample")
    long countByExample(AddressExample example);

    @DeleteProvider(type=AddressSqlProvider.class, method="deleteByExample")
    int deleteByExample(AddressExample example);

    @Delete({
        "delete from smbms_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into smbms_address (id, contact, ",
        "addressDesc, postCode, ",
        "tel, createdBy, creationDate, ",
        "modifyBy, modifyDate, ",
        "userId)",
        "values (#{id,jdbcType=BIGINT}, #{contact,jdbcType=VARCHAR}, ",
        "#{addressdesc,jdbcType=VARCHAR}, #{postcode,jdbcType=VARCHAR}, ",
        "#{tel,jdbcType=VARCHAR}, #{createdby,jdbcType=BIGINT}, #{creationdate,jdbcType=TIMESTAMP}, ",
        "#{modifyby,jdbcType=BIGINT}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{userid,jdbcType=BIGINT})"
    })
    int insert(Address record);

    @InsertProvider(type=AddressSqlProvider.class, method="insertSelective")
    int insertSelective(Address record);

    @SelectProvider(type=AddressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="addressDesc", property="addressdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="postCode", property="postcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdBy", property="createdby", jdbcType=JdbcType.BIGINT),
        @Result(column="creationDate", property="creationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifyBy", property="modifyby", jdbcType=JdbcType.BIGINT),
        @Result(column="modifyDate", property="modifydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="userId", property="userid", jdbcType=JdbcType.BIGINT)
    })
    List<Address> selectByExample(AddressExample example);

    @Select({
        "select",
        "id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, ",
        "modifyDate, userId",
        "from smbms_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="addressDesc", property="addressdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="postCode", property="postcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdBy", property="createdby", jdbcType=JdbcType.BIGINT),
        @Result(column="creationDate", property="creationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifyBy", property="modifyby", jdbcType=JdbcType.BIGINT),
        @Result(column="modifyDate", property="modifydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="userId", property="userid", jdbcType=JdbcType.BIGINT)
    })
    Address selectByPrimaryKey(Long id);

    @UpdateProvider(type=AddressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    @UpdateProvider(type=AddressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    @UpdateProvider(type=AddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Address record);

    @Update({
        "update smbms_address",
        "set contact = #{contact,jdbcType=VARCHAR},",
          "addressDesc = #{addressdesc,jdbcType=VARCHAR},",
          "postCode = #{postcode,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "createdBy = #{createdby,jdbcType=BIGINT},",
          "creationDate = #{creationdate,jdbcType=TIMESTAMP},",
          "modifyBy = #{modifyby,jdbcType=BIGINT},",
          "modifyDate = #{modifydate,jdbcType=TIMESTAMP},",
          "userId = #{userid,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Address record);
}