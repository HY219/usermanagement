package kr.ac.jejunu.usermenagement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

//    @PostMapping("/save")
//    public User create(@RequestBody User user){
//        return userRepository.save(user);
//    }

    @RequestMapping(path="/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

//    ////#image////
//    //GetMapping(path="/upload")
//    //파일을 업로드하는 로직
//    @RequestMapping(path = "/upload", method = RequestMethod.POST)
//    public User upload(@RequestParam User file, HttpServletRequest request) throws IOException {
//        File path = new File(request.getServletContext().getRealPath("/") + "/WEB-INF/static/" + file.getOriginalFilename()); //루트를 찾아올 수 있다. //static에 파일을 저장할 것이다.
//        //파일을 받기위한 string을 지정
//        //파일하고 연결을 해서 딱string으로 지정
//        FileOutputStream fileOutputStream = new FileOutputStream(path);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        bufferedOutputStream.write(file.getBytes()); //byte단위로 버퍼를 순서대로 쭉쭉..
//        User modelAndView = new User("upload");
//        //파일을 업로드 했을 때 화면에 이미지 띄워주기
//        modelAndView.addObject("url", "/images/" +file.getOriginalFilename());
//        return modelAndView;
//    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") int id) {
        return userRepository.findById(id).get(); //userRepository에 저장되어 있는.id를 꺼내옴.옵션
    }

//    @PutMapping("/save")
//    public User modify(@RequestBody User user) {
//        return userRepository.save(user);
//    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
