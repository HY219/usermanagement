package kr.ac.jejunu.usermenagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    MockMvc mvc;

    //가상 object
    @MockBean
    private UserController userController;
    @Autowired
    private ObjectMapper objectMapper;//user을 jsonString으로 변경

    String name = "정혜연";
    String password = "1234";
    @Test
    public void list() throws Exception {
        //가상 user object 만들기
        List<User> users = new ArrayList<>();
        int id = 1;

        User user = User.builder().id(id).name(name).build();
//        User user = new User();
//        //user에 필요한 정보
//        user.setId(id);
//        user.setName(name);
        users.add(user); //user정보를 users에 add

        //api가 호출이 되면 -> list가 호출이 되면 -> users라는 object를 리턴
        given(userController.list()).willReturn(users);
        mvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(id)))
                .andExpect(jsonPath("$[0].name", is(name)));

    }

    @Test
    public void create() throws Exception {

        User user = User.builder().name(name).password(password).build();
        given(userController.save(user)).willReturn(user);
        String jsonString = objectMapper.writeValueAsString(user);
        mvc.perform(post("/api/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    int id=1;

    @Test
    public void testGet() throws Exception{
        //어떤 controller메서드를 호출하고 어떤 값을 줄것인가
        User user = User.builder().id(id).name(name).password(password).build();
        given(userController.get(id)).willReturn(user);
        mvc.perform(get("/api/get/"+ String.valueOf(id))) //id값을 path로 넘김
                .andExpect(status().isOk()) //status는 Ok가 나와야한다.
                .andExpect(jsonPath("$.id", is(id))) //id는 is(id)와 같아야한다.
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.password", is(password)));
    }

    @Test
    public void modify() throws Exception {
        User user= User.builder().id(id).name(name).password(password).build();
        given(userController.save(user)).willReturn(user);
        String jsonString = objectMapper.writeValueAsString(user);
        mvc.perform(put("/api/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk());
    }
}
