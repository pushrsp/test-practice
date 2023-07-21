package sample.firsttest.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FirsttestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirsttestApplication.class, args);
    }

}
