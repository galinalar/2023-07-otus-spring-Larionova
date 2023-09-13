package spring03.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import spring03.service.LocaleProvider;
import spring03.service.LocalizationService;
import spring03.service.LocalizationServiceImpl;

@Configuration
@ConditionalOnProperty(value = "localization.autoconfiguration.enabled", havingValue = "true")
public class IOAutoconfiguration {

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @ConditionalOnMissingBean(LocalizationServiceImpl.class)
    @ConditionalOnBean(MessageSource.class)
    @Bean
    public LocalizationService localizationService(LocaleProvider localeProvider, MessageSource messageSource) {
        return new LocalizationServiceImpl(localeProvider, messageSource);
    }
}
