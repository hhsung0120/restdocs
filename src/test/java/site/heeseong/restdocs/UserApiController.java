package site.heeseong.restdocs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserApiController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }

    @Test
    public void selectUser() throws Exception{
        mockMvc.perform(
                    get("/users")
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
        mockMvc.perform(
                    put("/users")
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

