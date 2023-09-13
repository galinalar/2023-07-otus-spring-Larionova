package spring03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class LocalizationServiceImpl implements LocalizationService {

    private LocaleProvider localeProvider;

    private MessageSource messageSource;

    @Autowired
    public LocalizationServiceImpl(LocaleProvider localeProvider, MessageSource messageSource) {
        this.localeProvider = localeProvider;
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, localeProvider.getCurrent());
    }
}
