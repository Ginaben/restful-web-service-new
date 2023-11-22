package com.example.restfulwebservicenew.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor //모든 필드에 대해 파라미터로 갖는 생성자
public class User{
    private Integer id;
    private String name;
    private Date joinDate;
}
