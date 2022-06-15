package kr.ac.jejunu.usermenagement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data //getter, setter 자동 생성
@Builder //Object 편하게 생성
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "userinfo") //table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
}
