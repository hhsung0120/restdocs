package site.heeseong.restdocs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.heeseong.restdocs.model.User;
import site.heeseong.restdocs.service.UserApiService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserApiController {

    private final UserApiService userService;

    @GetMapping("/testData")
    public String insertTestData(){
        userService.saveTestUser();
        return "200";
    }

    @GetMapping("/{idx}")
    public User selectUser(@PathVariable Long idx){
        System.out.println("조회");
        return userService.selectUser(idx);
    }

    @PostMapping("")
    public String saveUser(){
        System.out.println("저장");
        userService.saveUser();
        return "200";
    }

    @PutMapping("/{idx}")
    public String updateUser(@PathVariable Long idx, @ModelAttribute User user){
        System.out.println("수정");
        userService.updateUser(idx, user);
        return "200";
    }

    @DeleteMapping("/{idx}")
    public String deleteUser(@PathVariable Long idx){
        System.out.println("삭제");
        userService.deleteUser(idx);
        return "200";
    }


}
