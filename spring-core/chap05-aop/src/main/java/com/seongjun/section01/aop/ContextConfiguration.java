package com.seongjun.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) //aop 기능을 사용하기 위해 사용한 어노테이션, 성능을 좋게 하기위해 proxyTargetClass = true.
public class ContextConfiguration {
}
