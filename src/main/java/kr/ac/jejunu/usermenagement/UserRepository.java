package kr.ac.jejunu.usermenagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Bean으로 선언
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();
}
