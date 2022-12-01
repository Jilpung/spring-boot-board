//package com.spring.boot.board.springbootboard.dto;
//
//import com.spring.boot.board.springbootboard.domain.entity.UserEntity;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//public class UserDto {
//    private Long id;
//    private String email;
//    private String password;
//    private String username;
//    private String nickname;
//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;
//
//    public UserEntity toEntity() {
//        return UserEntity.builder()
//                .id(id)
//                .email(email)
//                .password(password)
//                .username(username)
//                .nickname(nickname)
//                .build();
//    }
//
//    @Builder
//    public UserDto(Long id, String email, String password, String username, String nickname) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//        this.username = username;
//        this.nickname = nickname;
//    }
//}
