package hello.core.singleton;

import hello.core.Appconfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TextConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A사용자 10000원 주문
        int userAPrive = statefulService1.order("userA", 10000);
        // ThreadB: B사용자 20000원 주문
        int userBPrive = statefulService2.order("userB", 20000);

        // ThreadA: A사용자가 주문 금액을 조회
        System.out.println("userAPrive = " + userAPrive);
        System.out.println("userBPrive = " + userBPrive);
        // 10000원 결과값, 20000만원이 나왔다. stateless 무상태가 아닌, stateful 하다는 의미이다.

        Assertions.assertThat(userAPrive).isNotSameAs(userBPrive);
    }

    static class TextConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}