package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

            Map<String, MemberService> beansOfType = ac.getBeansOfType(MemberService.class);
            for(String key : beansOfType.keySet()){
                System.out.println("key = " + key + "value"+ beansOfType.get(key));
            }

            System.out.println("beansOfType = " + beansOfType);


        MemberService memberService = ac.getBean(MemberService.class);


        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }


}
