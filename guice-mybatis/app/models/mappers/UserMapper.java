package models.mappers;

import models.domains.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT id, email, name FROM user WHERE id = #{userId}")
    User getUser(@Param("userId") long userId);

}
