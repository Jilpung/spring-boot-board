//package com.spring.boot.board.springbootboard.common.auth;
//
//import com.spring.boot.board.springbootboard.domain.entity.UserEntity;
//import com.spring.boot.board.springbootboard.domain.repository.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component("userDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Transactional
//    public UserDetails loadUserByUsername(final String email) {
//        return userRepository.findOneWithAuthoritiesByEmail(email)
//                .map(userEntity -> createUser(email, userEntity))
//                .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스를 찾을 수 없습니다."));
//    }
//
//    private User createUser(String email, UserEntity userEntity) {
//        if(!userEntity.isActivated()) {
//            throw new RuntimeException(email + " -> 활성화되어 있지 않습니다.");
//        }
//        List<GrantedAuthority> grantedAuthorities = userEntity.getAuthorities().stream()
//                .map(authorityEntity -> new SimpleGrantedAuthority(authorityEntity.getAuthorityName()))
//                .collect(Collectors.toList());
//        return new User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);
//    }
//}
