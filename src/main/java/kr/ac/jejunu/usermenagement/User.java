package kr.ac.jejunu.usermenagement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter 자동 생성
@Builder //Object 편하게 생성
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
}
