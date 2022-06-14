package kr.ac.jejunu.usermenagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//하나의 spring bean
@RestController
@RequestMapping("/api") //응답
public class UserController {
    @GetMapping("/list")
    //User object 리스트로 생성
    public List<User> list() {
        return null;
    }


}
