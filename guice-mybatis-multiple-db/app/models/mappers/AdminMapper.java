package models.mappers;

import models.domains.Admin;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("SELECT id, email, name FROM admin WHERE id = #{userId}")
    Admin getUser(@Param("userId") long userId);

}
