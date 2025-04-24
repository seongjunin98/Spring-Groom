package com.seongjun.restapi.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(UserNotFoundException e) {

        String code = "Error_CODE_00001";
        String description = "회원 정보 조회 실패";
        String detail = e.getMessage();

        return new ResponseEntity<>(new ErrorResponse(code, description, detail),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e){

        String code = "";
        String  description = "";
        String detail = "";

        if(e.getBindingResult().hasErrors()) {

            detail = e.getBindingResult().getFieldError().getDefaultMessage(); // e.getMessage()
            System.out.println("detail = " + detail);

            String bindResultCode = e.getBindingResult().getFieldError().getCode(); // Notnull, Size....

            switch (bindResultCode) {
                case "NotBlank":
                    code = "ERROR_CODE_00002";
                    description = "필수 값이 누락되었습니다.";
                    break;
                case "Size":
                    code = "ERROR_CODE_00003";
                    description = "글자 수를 확인해야 합니다.";
                    break;
            }
        }

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.BAD_REQUEST);
    }

}
