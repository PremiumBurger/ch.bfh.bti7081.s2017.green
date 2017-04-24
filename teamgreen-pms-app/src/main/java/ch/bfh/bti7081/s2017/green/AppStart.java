package ch.bfh.bti7081.s2017.green;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
public class AppStart {
    private static final Logger log = LoggerFactory.getLogger(AppStart.class);

    public static void main(String[] args) {
        log.info("Starting Team Green PMS App");
        SpringApplication.run(AppStart.class, args);
    }
}
