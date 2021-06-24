package site.heeseong.restdocs.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import site.heeseong.restdocs.entity.UserEntity;

import java.time.LocalDateTime;

@Getter
public class User {

    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;

    public User() {}

    @Builder
    public User(Long id, String account, String email, String phoneNumber, LocalDateTime createDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .id(id)
                .account(account)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }

}
