package com.seongjun.section02.initdestroy.subsection02.annotation;

import com.seongjun.common.Beverage;
import com.seongjun.common.Bread;
import com.seongjun.common.Product;
import com.seongjun.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

//        String[] beanNames = context.getBeanDefinitionNames();
//        for(String beanName : beanNames){
//            System.out.println("beanName = " + beanName);
//        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 첫 번째 손님이 쇼핑카트를 꺼낸다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1? : " + cart1.getItem());

        /* 두 번째 손님 쇼핑카트 꺼낸다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2? : " + cart2.getItem());

        System.out.println(cart1.hashCode());
        System.out.println(cart2.hashCode());

        ((AnnotationConfigApplicationContext) context).close();  //컨테이너 강제 종료

    }
}
