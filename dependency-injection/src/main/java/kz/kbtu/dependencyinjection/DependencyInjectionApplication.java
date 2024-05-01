package kz.kbtu.dependencyinjection;

import kz.kbtu.dependencyinjection.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@Slf4j
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		Car toyota = getCarFromXml();

		log.info(String.valueOf(toyota));

		toyota = getCarFromJavaConfig();

		log.info(String.valueOf(toyota));
	}

	private static Car getCarFromJavaConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		return context.getBean(Car.class);
	}

	private static Car getCarFromXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("dependencyinjection.xml");

		return context.getBean(Car.class);
	}

}
