package site.heeseong.restdocs.model;

import lombok.Builder;
import lombok.Getter;
import site.heeseong.restdocs.entity.UserEntity;

@Getter
public class User {

    private Long id;
    private String account;
    private String email;
    private String phoneNumber;

    public User() {}

    @Builder
    public User(String account, String email, String phoneNumber) {
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .account(account)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }

}
