package com.example.restfulwebservicenew.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor //모든 필드에 대해 파라미터로 갖는 생성자
@JsonIgnoreProperties(value = {"password", "ssn"})
public class User{
    private Integer id;
    @Size(min=2, message = "Name은 두글자 이상 입력해주세요.")
    private String name;
    @Past(message = "등록일은 미래 날짜를 입력하실 수 없습니다.")
    private Date joinDate;

//    @JsonIgnore //이 값들을 사용자가 요청했을 때 공개해 주지 않겠다
    private String password;
//    @JsonIgnore
    private String ssn;
}
