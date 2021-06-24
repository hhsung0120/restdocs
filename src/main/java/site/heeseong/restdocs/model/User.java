package site.heeseong.restdocs.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public User() {}

}
