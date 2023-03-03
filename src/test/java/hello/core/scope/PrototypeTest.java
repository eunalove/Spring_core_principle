package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        //클래스를 직접 등록하면 자동으로 컴포넌트 스캔으로 되어서 등록이 됨
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);


        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean{

        @PostConstruct
        //스프링 빈 생성, 의존관계 주입 다음 초기화 콜백
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        //소멸전 콜백
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }


    }
}
