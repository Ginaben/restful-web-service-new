package com.example.restfulwebservicenew.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor //모든 필드에 대해 파라미터로 갖는 생성자
@NoArgsConstructor
@JsonFilter("UserInfoV2")
public class AdminUserV2 extends AdminUser{
    private String grade;

}
