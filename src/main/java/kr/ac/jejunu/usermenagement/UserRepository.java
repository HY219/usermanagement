package kr.ac.jejunu.usermenagement;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
}
