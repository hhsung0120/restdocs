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
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public UserEntity() {}

    @Builder
    public UserEntity(Long id, String account, String email, String phoneNumber) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
