package com.seongjun.section02.initdestroy.subsection02.annotation;

import com.seongjun.common.Beverage;
import com.seongjun.common.Bread;
import com.seongjun.common.Product;
import com.seongjun.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.seongjun.section02.initdestroy.subsection02.annotation")
public class ContextConfiguration {

    @Bean
    public Product carpBread(){

        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk(){

        return new Beverage("딸기우유", 1500, 500);

    }

    @Bean
    public Product water(){

        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){

        return new ShoppingCart();
    }



}
