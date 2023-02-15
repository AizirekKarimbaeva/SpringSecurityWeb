package com.peakosft.impl;

import com.peakosft.entity.MyUser;
import com.peakosft.entity.User;
import com.peakosft.repository.UserRepository;
import org.hibernate.service.UnknownServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


//    @Overri
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user =userRepository.getUserByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new MyUser(user);
   // }
    @Override
    public UserDetails loadUserByUsername(String email)  {
        User user =userRepository.getUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUser(user);
    }
}
