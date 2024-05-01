package kz.kbtu.autowire;

import kz.kbtu.autowire.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class AutowireApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireApplication.class);
		FooService fooService = ctx.getBean(FooService.class);
		log.info(fooService.doStuff());
//		SpringApplication.run(AutowireApplication.class, args);
	}

}
