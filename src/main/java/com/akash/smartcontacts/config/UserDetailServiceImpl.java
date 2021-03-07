package com.akash.smartcontacts.config;

import com.akash.smartcontacts.dao.UserRepository;
import com.akash.smartcontacts.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(s);

        if(user==null){
            throw  new UsernameNotFoundException("No user with user name "+s+" is found");
        }
        return new CustomUserDetail(user);
    }

}
