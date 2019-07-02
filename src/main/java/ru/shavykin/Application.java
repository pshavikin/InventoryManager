package ru.shavykin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.hateoas.config.EnableHypermediaSupport;


@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableHypermediaSupport(type={EnableHypermediaSupport.HypermediaType.HAL})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

