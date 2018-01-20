package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by daier on 2018/1/18.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user){
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(@Param("id") int id){
        userMapper.deleteUserById(id);
    }

    @Override
    public User getUserById(@Param("id") int id){
        return  userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    @Override
    public int userCount(){
        return userMapper.userCount();
    }
}
