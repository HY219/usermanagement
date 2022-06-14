package kr.ac.jejunu.usermenagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @Test
    public void list() throws Exception {
        //가상 user object 만들기
        List<User> users = new ArrayList<>();
        int id = 1;
        String name = "정혜연";
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
}
