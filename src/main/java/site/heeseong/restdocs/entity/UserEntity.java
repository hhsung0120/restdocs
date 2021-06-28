package site.heeseong.restdocs.entity;

import lombok.Builder;
import lombok.Getter;
import site.heeseong.restdocs.entity.common.TimeEntity;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "users")
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String userId;
    private String email;
    private String phoneNumber;

    public UserEntity() {}

    @Builder
    public UserEntity(String userId, String email, String phoneNumber) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void update(String userId, String email, String phoneNumber) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
