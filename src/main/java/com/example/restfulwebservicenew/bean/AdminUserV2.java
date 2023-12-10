package com.example.restfulwebservicenew.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor //모든 필드에 대해 파라미터로 갖는 생성자
@NoArgsConstructor
@JsonFilter("UserInfoV2")
public class AdminUserV2 extends AdminUser{
    private String grade;

}
