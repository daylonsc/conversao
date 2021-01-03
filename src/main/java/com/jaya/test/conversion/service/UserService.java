package com.jaya.test.conversion.service;

import com.jaya.test.conversion.domain.UserMain;
import com.jaya.test.conversion.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserMain getUser(HttpServletRequest request){
        return userRepository.findUserMainByUsername(request.getUserPrincipal().getName())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}