package com.spring.boot.board.springbootboard.service;

import com.spring.boot.board.springbootboard.domain.entity.Role;
import com.spring.boot.board.springbootboard.domain.entity.UserEntity;
import com.spring.boot.board.springbootboard.domain.repository.UserRepository;
import com.spring.boot.board.springbootboard.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    @Transactional
    public Long signup(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(userDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
        Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(email);
        UserEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@admin.com").equals(email)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }
        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

    @Transactional
    public void checkUsernameDuplication(UserDto userDto) {
        boolean usernameDuplicate = userRepository.existsByUsername(userDto.toEntity().getUsername());
        if(usernameDuplicate) {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
    }
    @Transactional
    public void checkNicknameDuplication(UserDto userDto) {
        boolean nicknameDuplicate = userRepository.existsByNickname(userDto.toEntity().getNickname());
        if(nicknameDuplicate) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }
    @Transactional
    public void checkEmailDuplication(UserDto userDto) {
        boolean emailDuplicate = userRepository.existsByEmail(userDto.toEntity().getEmail());
        if(emailDuplicate) {
            throw new IllegalStateException("이미 존재하는 email 입니다.");
        }
    }

}
