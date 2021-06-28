package site.heeseong.restdocs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.heeseong.restdocs.entity.UserEntity;
import site.heeseong.restdocs.model.User;
import site.heeseong.restdocs.repository.UserRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

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
    public void updateUser() throws IllegalArgumentException{
        UserEntity userEntity = selectUser(1L);
        userEntity.update("update","email@update.com","010-1234-5678");
    }

    public void deleteUser() throws IllegalArgumentException{
        userRepository.delete(selectUser(1L));
    }

    public UserEntity selectUser(Long idx){
        return userRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("user not fount"));
    }
}
