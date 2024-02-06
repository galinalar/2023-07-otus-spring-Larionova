package spring1516;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import spring1516.services.ManuscriptService;

@Slf4j
@SpringBootApplication
public class Main1516 {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main1516.class, args);

        ManuscriptService manuscriptService = ctx.getBean(ManuscriptService.class);
        manuscriptService.startPublishingHouseWork();
    }
}