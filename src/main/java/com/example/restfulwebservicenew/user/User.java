package com.example.restfulwebservicenew.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor //모든 필드에 대해 파라미터로 갖는 생성자
public class User{
    private Integer id;
    @Size(min=2, message = "Name은 두글자 이상 입력해주세요.")
    private String name;
    @Past
    private Date joinDate;
}
