package com.example.share.service;

import com.example.share.entity.User;

import java.util.List;


public interface UserService {

    void insert(User user);

    void deleteByIds(String ids);

    void updateById(User user);

    User selectById(Integer id);

    List<User> selectList(String whereStr);

    User selectByUsername(String username);
}