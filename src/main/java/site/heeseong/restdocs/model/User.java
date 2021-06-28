package site.heeseong.restdocs.model;

import lombok.Builder;
import lombok.Getter;
import site.heeseong.restdocs.entity.UserEntity;

@Getter
public class User {

    private Long idx;
    private String userId;
    private String email;
    private String phoneNumber;

    public User() {}

    @Builder
    public User(Long idx, String userId, String email, String phoneNumber) {
        this.idx = idx;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(userId)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }

}
