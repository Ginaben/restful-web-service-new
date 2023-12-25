package com.example.restfulwebservicenew.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor //모든 필드에 대해 파라미터로 갖는 생성자
@JsonIgnoreProperties(value = {"password", "ssn"})
@Schema(description = "사용자 상세 정보를 위한 도메인 객체")
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Schema(title="사용자 ID", description = "사용자 ID는 자동 생성됩니다.")
    @Id
    @GeneratedValue
    private Integer id;

    @Schema(title="사용자 이름", description = "사용자 이름을 입력합니다.")
    @Size(min=2, message = "Name은 두글자 이상 입력해주세요.")
    private String name;
    @Schema(title="사용자 등록자", description = "사용자 등록일을 입력합니다 입력하지 않으면 현재 날짜가 지정됩니다.")
    @Past(message = "등록일은 미래 날짜를 입력하실 수 없습니다.")
    private Date joinDate;

//    @JsonIgnore //이 값들을 사용자가 요청했을 때 공개해 주지 않겠다
    @Schema(title="사용자 비밀번호", description = "사용자 비밀번호를 입력합니다.")
    private String password;

//    @JsonIgnore
    @Schema(title="사용자 비밀번호", description = "사용자 비밀번호를 입력합니다.")
    private String ssn;
}
