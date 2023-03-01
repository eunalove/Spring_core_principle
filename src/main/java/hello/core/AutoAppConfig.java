package hello.core;
//여기서부터 시작해서 하위패키지를 뒤짐
//basePackages를 지정하지 않으면 이게 디폴트임

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberMemoryRepository;
import hello.core.member.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
//보통 exclude를 하진 않지만 기존 예제코드를 지키기 위해서 이용함
)

public class AutoAppConfig {


   /*

   @Autowired MemberRepository memberRepository;
    @Autowired DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy);
    }*/

    /*
    @Bean(name = "memberMemoryRepository")
    //(name = "memoryMemberRepository")-> 에러 이거 나중에 나올 문제인데 같은 타입이여서 문제가 됨
    //(name = "memberMemoryRepository")-> 에러안남 왜냐면 같은 이름으로 오버라이딩해서 얘도 core로 돌리면 에러남

    public MemberRepository memberRepository() {
        return new MemberMemoryRepository();
    }

*/
}
