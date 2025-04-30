package com.seongjun.mission05.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {

    @NotBlank(message = "이름은 필수입니다.")
    @Size(min = 2, message = "2글자 이상의 이름을 작성해주세요.")
    private String name;

    @NotBlank(message = "이메일은 필수입니다.")
    @Size(message = "올바르지 않은 이메일 형식입니다.")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
