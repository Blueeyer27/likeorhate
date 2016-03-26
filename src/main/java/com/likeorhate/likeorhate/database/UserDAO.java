package com.likeorhate.likeorhate.database;

import com.likeorhate.likeorhate.domain.User;

import java.util.List;

public interface UserDAO {
    void create(User user) throws DBException;
    User getById(Long id) throws DBException;
    void delete(Long id) throws DBException;
    void update(User user) throws DBException;
    List<User> getAll() throws DBException;
}
