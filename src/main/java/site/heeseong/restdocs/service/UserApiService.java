package site.heeseong.restdocs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.heeseong.restdocs.entity.UserEntity;
import site.heeseong.restdocs.model.User;
import site.heeseong.restdocs.repository.UserRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserApiService {

    private final UserRepository userRepository;

    public void saveUser() {
        User user = User.builder()
                        .account("test1")
                        .email("test@test.com")
                        .phoneNumber("010-1234-7777")
                        .build();

        userRepository.save(user.toEntity());
    }

    @Transactional
    public void updateUser(Long idx, User user) throws IllegalArgumentException{
        UserEntity userEntity = existUser(idx);
        userEntity.update(user.getAccount(), user.getEmail(), user.getPhoneNumber());
    }

    public void deleteUser(Long idx) throws IllegalArgumentException{
        userRepository.delete(existUser(idx));
    }

    public UserEntity existUser(Long idx){
        return userRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("user not fount"));
    }

    public User selectUser(Long idx) {
        UserEntity userEntity = existUser(idx);
        return User.builder()
                    .idx(userEntity.getIdx())
                    .account(userEntity.getAccount())
                    .phoneNumber(userEntity.getPhoneNumber())
                    .email(userEntity.getEmail())
                    .build();
    }

    public void saveTestUser() {
        for(int i=0; i<10; i++){
            this.saveUser();
        }
    }
}
