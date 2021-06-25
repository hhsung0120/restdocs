package site.heeseong.restdocs.entity;

import lombok.Builder;
import lombok.Getter;
import site.heeseong.restdocs.entity.common.TimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String email;
    private String phoneNumber;

    public UserEntity() {}

    @Builder
    public UserEntity(String account, String email, String phoneNumber) {
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserEntity update(String account, String email, String phoneNumber) {
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
        return this;
    }
}
