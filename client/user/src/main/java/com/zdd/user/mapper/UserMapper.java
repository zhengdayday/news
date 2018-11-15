package com.zdd.user.mapper;

import com.zdd.user.model.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id,mobile,password from news_user where mobile = #{mobile} and password = #{password}")
    List<UserBean> selectUser(String mobile,String password);

    @Select("select id,mobile,password from news_user where mobile = #{mobile}")
    List<UserBean> selectUser(String mobile);
}
