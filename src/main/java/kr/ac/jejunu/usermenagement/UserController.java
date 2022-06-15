package kr.ac.jejunu.usermenagement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//하나의 spring bean
@RestController
@RequestMapping("/api") //응답
@RequiredArgsConstructor //final이 붙은 필드의 생성자를 자동으로 생성해줌
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/list")
    //User object 리스트로 생성
    public List<User> list() {
        List<User> users = userRepository.findAll(); //저장되어있는 모든 데이터를 가져와서
        return users; //리턴
       // return null;
    }

    @PostMapping("/save")
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }


}
