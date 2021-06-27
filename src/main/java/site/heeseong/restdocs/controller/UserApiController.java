package site.heeseong.restdocs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.heeseong.restdocs.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserApiController {

    private final UserService userService;

    @PostMapping("")
    public String userSave(){
        System.out.println("저장 입니다.");
        //userService.saveUsers();
        return "200";
    }

    @PutMapping("")
    public String userUpdate(){
        userService.saveUsers();
        return "200";
    }


}
