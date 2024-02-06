package spring1516.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.MessageChannelSpec;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.PollerSpec;
import org.springframework.integration.scheduling.PollerMetadata;
import spring1516.domain.Book;
import spring1516.services.TypewriterService;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannelSpec<?, ?> manuscriptChannel() {
        return MessageChannels.queue(10);
    }

    @Bean
    public MessageChannelSpec<?, ?> bookChannel() {
        return MessageChannels.publishSubscribe();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerSpec poller() {
        return Pollers.fixedRate(100).maxMessagesPerPoll(2);
    }

    @Bean
    public IntegrationFlow publishingHouseFlow(TypewriterService typewriterService) {
        return IntegrationFlow.from(manuscriptChannel())
                .split()
                .handle(typewriterService, "print")
                .<Book, Book>transform(b -> new Book(b.getName(), b.getText(), true))
                .aggregate()
                .channel(bookChannel())
                .get();
    }
}
