//package com.spring.boot.board.springbootboard.controller;
//
//import com.spring.boot.board.springbootboard.common.jwt.JwtFilter;
//import com.spring.boot.board.springbootboard.common.jwt.TokenProvider;
//import com.spring.boot.board.springbootboard.dto.LoginDto;
//import com.spring.boot.board.springbootboard.dto.TokenDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api")
//public class AuthController {
//
//    private final TokenProvider tokenProvider;
//    private final AuthenticationManagerBuilder authenticationManagerBuilder;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
//
//        //authenticationManagerBuilder가 호출되면서 CustomUserDetailService가 로드됨.
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = tokenProvider.createToken(authentication);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
//
//        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
//    }
//}