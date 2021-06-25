package site.heeseong.restdocs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.heeseong.restdocs.model.User;
import site.heeseong.restdocs.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void saveUsers() {
        User user = User.builder()
                        .account("test1")
                        .email("test@test.com")
                        .phoneNumber("010-1234-7777")
                        .build();

        userRepository.save(user.toEntity());
    }
}
