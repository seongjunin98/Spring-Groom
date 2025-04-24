package com.seongjun.restapi.section03.valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class UserDTO {

    /* 유효성 체크 어노테이션
     * @Null // null만 허용합니다.
     * @NotNull // null을 허용하지 않습니다 "", " "는 허용합니다.
     * @NotEmpty // null, ""을 허용하지 않습니다. " "는 허용합니다.
     * @NotBlank // null, "", " " 모두 허용하지 않습니다.
     *
     * @Email // 이메일 형식을 검사합니다. 다만 ""의 경우를 통과 시킵니다
     * @Pattern(regexp = ) // 정규식을 검사할 때 사용됩니다.
     *   --> regexp="[a-z1-9]{6-10}", message = "비밀번호는 영어와 숫자로 포함해서 6~10자리 이내로"
     * @Size(min=, max= ) // 길이를 제한할 때 사용됩니다.
     * @Max(value= ) // value 이하의 값을 받을 때 사용됩니다.
     * @Min(value= ) // value 이상의 값을 받을 때 사용됩니다.
     *
     * @Positive // 값을 양수로 제한합니다.
     * @PositiveOrZero // 값을 양수와 0만 가능하도록 제한합니다.
     * @Negative // 값을 음수로 제한합니다.
     * @NegativeOrZero // 값을 음수와 0만 가능하도록 제한합니다.
     *
     * @Future //현재보다 미래 - 미래날짜
     * @Past //현재보다 과거 - 과거날짜
     *
     * @AssertFalse   // false여부, null은 체크하지 않습니다.
     * @AssertTrue    // true 여부, null은 체크하지 않습니다.
     * */

    private int no;

    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String id;
    private String pwd;

    @NotNull(message = "이름은 반드시 입력되어야 합니다.")
    @Size(min = 2, message = "이름은 2글자 이상 입력되어야 합니다.")
    private String name;

    @Past
    private Date enrollDate;

    public UserDTO() {}

    public UserDTO(int no, String id, String pwd, String name, Date enrollDate) {
        this.no = no;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
