package com.seongjun.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 전역 예외 처리를 담당 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("Global 레벨의 exception 처리");

        return "error/nullPointer";
    }

    /* 상위 타입인 Exception을 이용하면 구체적으로 작성하지 않은 타입의 에러가 발생하더라도
    *  처리가 가능하므로 default 처리 용도로 사용할 수 있다.*/
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception exception) {

        return "error/default";
    }

}
