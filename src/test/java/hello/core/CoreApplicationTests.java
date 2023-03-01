package hello.core;

import hello.core.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

	//특수한 경우 테스트코드에서 @Autowired 사용해도 됨
	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
	}

}
