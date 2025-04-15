package com.seongjun.mission04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

          try  (AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config.class)) {
              BeanUser user = context.getBean(BeanUser.class);
              user.checkBean();
          } catch (Exception e){
              System.out.println("오류 발생 : " + e.getMessage());
          }

    }
}
