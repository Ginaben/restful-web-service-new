package com.example.restfulwebservicenew;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //세터 게터 생성자 투스트링
@AllArgsConstructor
public class HelloWorldBean {
    private String message;

/*  //롬복 사용해서 아래 내용 안써도 됨
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String msg) {
        this.message = msg;
    }*/

/* // Allargument가 이역할을 함
    public HelloWorldBean(String helloWorld) {
        this.message = message;
    }*/
}
