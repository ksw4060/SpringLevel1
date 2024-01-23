package hello.core.beandefinition;

import hello.core.Appconfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    // class 파일이 아닌, Xml 파일로 설정가능
//    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
    // ApplicationContext 를 하면, getBeanDefinition 함수를 사용할 수 없다.
    // 섹션 4-8. 11분30초.
    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void finApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName);
                System.out.println("beanDefinition = " + beanDefinition);
            }
        }
    }
}

// 현재 자바에서 Config.class 를 통해 Configuration 을 하는 방법이
// 펙토리 메서드를 통한 구현이라고 한다. 직접 설정하는 방법이 XmlAppContext 방법이다.