package com.peakosft.service;


import com.peakosft.entity.Role;
import com.peakosft.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void save(User user);
    void update(Long id,User user);
    User getById(Long id);
    List<User> getAll();
    User getUserByUsername(String username);
    User getUserByEmail(String email);
//    Set<Role> getByRolesByUserId(Long id);

}
