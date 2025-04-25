package com.seongjun.mission12;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Transactional
    public void doTransaction(boolean fail) {
        System.out.println("비즈니스 로직 실행 중...");
        if (fail) {
            throw new RuntimeException("오류 발생! 롤백됩니다.");
        }
        System.out.println("비즈니스 로직 완료");
    }
}
