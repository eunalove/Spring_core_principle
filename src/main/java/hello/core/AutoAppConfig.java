package hello.core;
//여기서부터 시작해서 하위패키지를 뒤짐
//basePackages를 지정하지 않으면 이게 디폴트임

import hello.core.member.MemberMemoryRepository;
import hello.core.member.MemberRepository;
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

    @Bean(name = "memberMemoryRepository")
    //(name = "memoryMemberRepository")-> 에러
    //(name = "memberMemoryRepository")-> 에러안남
    public MemberRepository memberRepository() {
        return new MemberMemoryRepository();
    }

}
