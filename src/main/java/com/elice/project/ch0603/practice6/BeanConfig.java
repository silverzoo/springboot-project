package com.elice.project.ch0603.practice6;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    // 지시 사항에 따라 코드를 작성해 보세요.
    @Bean
    @Scope("prototype")
    Counter prototypeCounter() {
        return new Counter();
    }

    @Bean
        //@Scope("singleton") //생략해도 디폴트기때문에 정상작동한다
    Counter singletonCounter() {
        return new Counter();
    }
}
