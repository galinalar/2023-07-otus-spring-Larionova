package spring04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DefaultLocaleProviderImpl implements LocaleProvider {

    private Locale localeTag;

    @Autowired
    public DefaultLocaleProviderImpl(@Value("${localization.locale}") String localeTag) {
        this.localeTag = Locale.forLanguageTag(localeTag);
    }

    @Override
    public Locale getCurrent() {
        return localeTag;
    }
}
