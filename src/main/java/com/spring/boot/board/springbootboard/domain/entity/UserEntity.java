//package com.spring.boot.board.springbootboard.domain.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table(name = "user")
//public class UserEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(length = 50, nullable = false)
//    private String email;
//    @Column(length = 20, nullable = false)
//    private String password;
//    @Column(length = 20, nullable = false, unique = true)
//    private String username;
//    @Column(length = 20, nullable = false)
//    private String nickname;
//    private Boolean authority;
//
//    @Builder
//    public UserEntity(Long id, String email, String username, String password, String nickname){
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.username = username;
//        this.nickname = nickname;
//    }
//
//
//}
