package com.example.serverfor_test0.mapper;

import com.example.serverfor_test0.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from sys_user")
    List<User> findAll();
    @Insert("insert into sys_user(username,password,nickname,email,phone,address) values (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);

//    @Update("update sys_user set username = #{username},password = #{password},nickname = #{nickname},email = #{email},phone=#{phone},address=#{address} where id = #{id}")
    /**
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     *
     * @param id
     * @return
     */
    @Delete("delete from sys_user where id =#{id}")
    Integer deleteById(@Param("id") Integer id);

    /**
     *
     * @param pageNum  页码
     * @param pageSize 每页查询的个数
     * @return  分页查询的结果
     */
    @Select("select * from sys_user where username like concat('%',#{username},'%') limit #{pageNum},#{pageSize}")
    List<User> selectPage(Integer pageNum,Integer pageSize,String username);

    /**
     *
     * 统计数据个数
     * @return返回个数  注意是个数不是全部数据
     */
    @Select("select count(*) from sys_user where username like concat('%',#{username},'%')")
    Integer selectTotal(String username);
}
