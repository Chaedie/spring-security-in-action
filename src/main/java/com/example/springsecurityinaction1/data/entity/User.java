package com.example.springsecurityinaction1.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private String authority;
}
