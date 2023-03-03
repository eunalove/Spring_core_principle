package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycelConfig.class);
        NetworClient client = ac.getBean(NetworClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycelConfig{

        @Bean
        public NetworClient networClient(){
            NetworClient networClient = new NetworClient();
            networClient.setUrl("http://hello-spring.dev");
            networClient.printUrl();
            return networClient;
        }
    }
}
