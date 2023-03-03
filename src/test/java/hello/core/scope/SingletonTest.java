package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletoneBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        //클래스를 직접 등록하면 자동으로 컴포넌트 스캔으로 되어서 등록이 됨

        SingletonBean singletoneBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletoneBean2 = ac.getBean(SingletonBean.class);
        System.out.println("SingletoneBean1 = " + singletoneBean1);
        System.out.println("SingletoneBean2 = " + singletoneBean2);
        assertThat(singletoneBean1).isSameAs(singletoneBean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        //스프링 빈 생성, 의존관계 주입 다음 초기화 콜백
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        //소멸전 콜백
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }

    }
}
