package com.seongjun.section02.javaconfig;

import com.seongjun.common.Account;
import com.seongjun.common.MemberDTO;
import com.seongjun.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {

        return new PersonalAccount("110-234-567890", 1000);
    }

    @Bean
    public MemberDTO memberGenerator(){

        /* MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
        // return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());

        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong123@gamil.com");
        /* setter를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
        member.setPersonalaccount(accountGenerator());


        return member;
    }


}
