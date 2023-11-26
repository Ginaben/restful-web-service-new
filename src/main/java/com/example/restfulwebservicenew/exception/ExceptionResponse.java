package com.example.restfulwebservicenew.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor //ㅁㅗ든 필드르 가지고있는 생성자
@NoArgsConstructor //매개변수가 없는 디폴트 생성자
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
