package kz.kbtu.scopes;

import kz.kbtu.scopes.Model.HelloMessageGenerator;
import kz.kbtu.scopes.Model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class ScopesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScopesApplication.class, args);
	}

}
