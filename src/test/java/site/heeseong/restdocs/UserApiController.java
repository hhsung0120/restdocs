package site.heeseong.restdocs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import site.heeseong.restdocs.model.User;
import site.heeseong.restdocs.service.UserApiService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserApiController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserApiService userApiService;

    @BeforeEach
    public void setUpData(){
        userApiService.saveTestUser();
    }

    @Test
    public void selectUser() throws Exception{
        mockMvc.perform(
                    get("/users/1")
                )
                .andExpect(status().isOk());
    }

    @Test
    public void saveUser() throws Exception{
        mockMvc.perform(
                    post("/users")
                )
                //.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateUser() throws Exception{
        //given
        User user = User.builder()
                        .account("테스트수정")
                        .email("테스트 email 수정")
                        .phoneNumber("010수정")
                        .build();


        mockMvc.perform(
                    put("/users", user)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception{
        mockMvc.perform(
                    delete("/users")
                )
                .andExpect(status().isOk());
    }
}

