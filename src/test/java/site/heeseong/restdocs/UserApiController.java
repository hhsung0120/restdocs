package site.heeseong.restdocs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import site.heeseong.restdocs.service.UserApiService;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static site.heeseong.restdocs.ApiDocumentUtils.getDocumentRequest;
import static site.heeseong.restdocs.ApiDocumentUtils.getDocumentResponse;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com")
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
                                        parameterWithName("idx").description("?????? ??????")
                                )
                                , responseFields(
                                        fieldWithPath("idx").type(JsonFieldType.NUMBER).description("?????? ??????")
                                        , fieldWithPath("userId").type(JsonFieldType.STRING).description("?????????")
                                        , fieldWithPath("email").type(JsonFieldType.STRING).description("?????????")
                                        , fieldWithPath("phoneNumber").type(JsonFieldType.STRING).description("????????? ??????")
                                )
                        ))
                .andDo(print());


            //?????? ?????? ?????? ?????? ??????
            /*FieldDescriptor[] faqs = new FieldDescriptor[]{
                    fieldWithPath("dataList[].idx").type(JsonFieldType.NUMBER).description("?????? ??????")
                    , fieldWithPath("dataList[].categoryName").type(JsonFieldType.STRING).description("????????????")
                    , fieldWithPath("dataList[].title").type(JsonFieldType.STRING).description("??????")
                    , fieldWithPath("dataList[].contents").type(JsonFieldType.STRING).description("??????")
                    , fieldWithPath("dataList[].createDate").type(JsonFieldType.STRING).description("?????? ??????")
                    , fieldWithPath("dataList[].lastModifiedDate").type(JsonFieldType.STRING).description("?????? ??????")
            };

            result.andExpect(status().isOk())
                    .andDo(
                            document("faqs"
                                    , getDocumentRequest()
                                    , getDocumentResponse()
                                    , pathParameters(
                                            parameterWithName("page").description("????????? ??????")
                                    )
                                    , responseFields(faqs)
                            )
                    )
                    .andDo(print());
            }*/
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
//                        .userId("???????????????")
//                        .email("????????? email ??????")
//                        .phoneNumber("010??????")
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

