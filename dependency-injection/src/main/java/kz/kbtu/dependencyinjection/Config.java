package kz.kbtu.dependencyinjection;

import kz.kbtu.dependencyinjection.model.Engine;
import kz.kbtu.dependencyinjection.model.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kz.kbtu.dependencyinjection")
public class Config {

    @Bean
    public Engine engine() {
        return new Engine("v8", 5);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }
}
