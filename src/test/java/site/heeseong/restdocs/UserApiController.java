package site.heeseong.restdocs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import site.heeseong.restdocs.model.User;
import site.heeseong.restdocs.service.UserApiService;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static site.heeseong.restdocs.ApiDocumentUtils.getDocumentRequest;
import static site.heeseong.restdocs.ApiDocumentUtils.getDocumentResponse;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com") // (1)
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

        ResultActions result = this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/users/{idx}", 1L)
        );

        result.andExpect(status().isOk())
                .andDo(
                        document("select-user"
                                , getDocumentRequest()
                                , getDocumentResponse()
                                , pathParameters(
                                        parameterWithName("idx").description("고유 번호")
                                )
                                , responseFields(
                                        fieldWithPath("idx").type(JsonFieldType.NUMBER).description("고유 번호")
                                        , fieldWithPath("userId").type(JsonFieldType.STRING).description("아이디")
                                        , fieldWithPath("email").type(JsonFieldType.STRING).description("이메일")
                                        , fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("휴대폰 번호")
                                )
                        ));
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
//        //given
//        User user = User.builder()
//                        .userId("테스트수정")
//                        .email("테스트 email 수정")
//                        .phoneNumber("010수정")
//                        .build();
//
//
//        mockMvc.perform(
//                    put("/users", user)
//                )
//                .andExpect(status().isOk());
    }

    @Test
    public void deleteUser() throws Exception{
//        mockMvc.perform(
//                    delete("/users")
//                )
//                .andExpect(status().isOk());
    }
}

