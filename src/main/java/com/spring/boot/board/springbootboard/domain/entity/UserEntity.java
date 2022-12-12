package com.spring.boot.board.springbootboard.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false, unique = true)
    private String username;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickname;

    private boolean activated;

//    @ManyToMany
//    @JoinTable(
//            name = "user_authority",
//            joinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
//    )
//    private Set<AuthorityEntity> authorities;
    @Builder
    public UserEntity(Long id, String email, String username, String password, String nickname){
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
    }

}
