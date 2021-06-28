package site.heeseong.restdocs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.heeseong.restdocs.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserApiController {

    private final UserService userService;

    @GetMapping("/testData")
    public String insertTestData(){
        for(int i=0; i<10; i++){
            userService.saveUser();
        }
        return "200";
    }

    @GetMapping("")
    public String test(){
        System.out.println("조회");
        userService.selectUser(1L);
        return "200";
    }

    @PostMapping("")
    public String saveUser(){
        System.out.println("저장");
        userService.saveUser();
        return "200";
    }

    @PutMapping("")
    public String updateUser(){
        System.out.println("수정");
        userService.updateUser();
        return "200";
    }

    @DeleteMapping("")
    public String deleteUser(){
        System.out.println("삭제");
        userService.deleteUser();
        return "200";
    }


}
