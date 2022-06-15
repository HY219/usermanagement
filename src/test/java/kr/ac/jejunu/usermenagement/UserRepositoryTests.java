package kr.ac.jejunu.usermenagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

@DataJpaTest //Jpa기반으로 test
public class UserRepositoryTests {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findAll(){
        //Integer id = 1;
        String name ="정혜연";
        User user = User.builder().name(name).build();
        entityManager.persist(user);
        List<User> users = userRepository.findAll(); //call
        //검증
        assertThat(users.get(0).getId(), greaterThan(0)); //결과, 첫번째 있는 getId는 0보다 클 것이다.
        assertThat(users.get(0).getName(), is(name)); //첫번째 있는 getName은 name과 동일할 것이다.
    }
}
