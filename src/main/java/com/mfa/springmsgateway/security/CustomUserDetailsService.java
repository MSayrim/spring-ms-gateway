package com.mfa.springmsgateway.security;

import com.mfa.springmsgateway.model.User;
import com.mfa.springmsgateway.repository.IUserRepository;
import com.mfa.springmsgateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username:"+username));

        return new UserPrincipal(user.getId(), user.getUsername(),user.getPassword());
    }
}
