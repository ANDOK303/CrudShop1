package com.andresGonzalez.CRUDShop.service;

import com.andresGonzalez.CRUDShop.entity.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User getById(Integer id);
    User create(User user);
    User update(Integer id, User user);
    void delete(Integer id);
}