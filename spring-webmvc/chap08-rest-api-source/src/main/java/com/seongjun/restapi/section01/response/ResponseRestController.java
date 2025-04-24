package com.seongjun.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/response")
public class ResponseRestController {

    /* 1. 문자열 응답 */
    @GetMapping("/hello")
    public String helloworld() {

        return "hello world";
    }

    /* 2. 기본자료형 응답 */
    @GetMapping("/random")
    public int getRandomNuber() {

        return (int) (Math.random()*10) + 1;
    }

    /* 3. Object */
    @GetMapping("/message")
    public Message getMessage(){

        return new Message(200, "=== 응답 메세지 ===");
    }

    /* 4. List 응답 */
    @GetMapping("/list")
    public List<String> getList(){

        return List.of(new String[] {"떡볶이", "튀김", "김밥"});
    }

    /* 5. Map 응답 */
    @GetMapping("/map")
    public Map<Integer, String> getMap() {

        Map<Integer, String> messageMap = new HashMap<>();
        messageMap.put(200, "정상응답");
        messageMap.put(404, "페이지를 찾을 수 없음");
        messageMap.put(500, "서버 내부 에러 == 개발자의 잘못");

        return messageMap;

    }

    /* 6. ImageFile 응답 */
    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {

        return getClass().getResourceAsStream("/images/댕댕.PNG").readAllBytes();
    }

    /* 7. ResponseEntity 응답 */
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {

        return ResponseEntity.ok(new Message(123, "hello rest~"));
    }
}
