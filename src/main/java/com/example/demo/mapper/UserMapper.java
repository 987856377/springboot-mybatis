package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by daier on 2018/1/18.
 */
@Mapper
@Repository
public interface UserMapper {

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(@Param("id") int id);

    User getUserById(@Param("id") int id);

    List<User> getAllUser();

    int userCount();
}
