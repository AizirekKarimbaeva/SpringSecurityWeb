package com.peakosft.impl;

import com.peakosft.entity.Role;
import com.peakosft.entity.User;
import com.peakosft.repository.RoleRepository;
import com.peakosft.repository.UserRepository;
import com.peakosft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void save(User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByRoleName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user1.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void update(Long id, User user) {
     User user1 = userRepository.getById(id);
     user1.setUsername(user.getUsername());
     user1.setPassword(user.getPassword());
     user1.setRoles(user.getRoles());
     userRepository.save(user1);
    }

    @Override
    public User getById(Long id) {
       return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

//    @Override
//    public Set<Role> getByRolesByUserId(Long id) {
//        return userRepository.getRolesByUserId(id);
//    }
}
