package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.entity.User;
import cn.com.demo.springboot.demo.entity.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from smbms_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into smbms_user (id, userCode, ",
        "userName, userPassword, ",
        "gender, birthday, phone, ",
        "address, userRole, ",
        "createdBy, creationDate, ",
        "modifyBy, modifyDate, ",
        "idPicPath)",
        "values (#{id,jdbcType=BIGINT}, #{usercode,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{userpassword,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=INTEGER}, #{birthday,jdbcType=DATE}, #{phone,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{userrole,jdbcType=INTEGER}, ",
        "#{createdby,jdbcType=BIGINT}, #{creationdate,jdbcType=TIMESTAMP}, ",
        "#{modifyby,jdbcType=BIGINT}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{idpicpath,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userCode", property="usercode", jdbcType=JdbcType.VARCHAR),
        @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="userPassword", property="userpassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="userRole", property="userrole", jdbcType=JdbcType.INTEGER),
        @Result(column="createdBy", property="createdby", jdbcType=JdbcType.BIGINT),
        @Result(column="creationDate", property="creationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifyBy", property="modifyby", jdbcType=JdbcType.BIGINT),
        @Result(column="modifyDate", property="modifydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idPicPath", property="idpicpath", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, ",
        "createdBy, creationDate, modifyBy, modifyDate, idPicPath",
        "from smbms_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results(id="UserResult", value={
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userCode", property="usercode", jdbcType=JdbcType.VARCHAR),
        @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="userPassword", property="userpassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="userRole", property="userrole", jdbcType=JdbcType.INTEGER),
        @Result(column="createdBy", property="createdby", jdbcType=JdbcType.BIGINT),
        @Result(column="creationDate", property="creationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modifyBy", property="modifyby", jdbcType=JdbcType.BIGINT),
        @Result(column="modifyDate", property="modifydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="idPicPath", property="idpicpath", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);
    @Select({
            "select",
            "id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, ",
            "createdBy, creationDate, modifyBy, modifyDate, idPicPath",
            "from smbms_user",
            "where userCode = #{userCode,jdbcType=VARCHAR}"
    })
    @ResultMap(value = "UserResult")//定义字段属性的对应
    User selectByUserCode(String userCode);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update smbms_user",
        "set userCode = #{usercode,jdbcType=VARCHAR},",
          "userName = #{username,jdbcType=VARCHAR},",
          "userPassword = #{userpassword,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=DATE},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "userRole = #{userrole,jdbcType=INTEGER},",
          "createdBy = #{createdby,jdbcType=BIGINT},",
          "creationDate = #{creationdate,jdbcType=TIMESTAMP},",
          "modifyBy = #{modifyby,jdbcType=BIGINT},",
          "modifyDate = #{modifydate,jdbcType=TIMESTAMP},",
          "idPicPath = #{idpicpath,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}