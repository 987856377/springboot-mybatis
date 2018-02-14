package com.example.demo.service;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by daier on 2018/1/18.
 */
public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(@Param("id") int id);

    User getUserById(@Param("id") int id);

    List<User> getAllUser();

    int userCount();
}
