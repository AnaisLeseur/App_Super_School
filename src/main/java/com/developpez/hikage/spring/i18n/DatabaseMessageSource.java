package com.developpez.hikage.spring.i18n;

import org.springframework.context.support.AbstractMessageSource;

import java.text.MessageFormat;
import java.util.Locale;

import com.developpez.hikage.spring.i18n.service.MessageMngt;


public class DatabaseMessageSource extends AbstractMessageSource {

    // Référence à la couche service
    private MessageMngt messageMngt;

    public void setMessageMngt(MessageMngt messageMngt) {
        this.messageMngt = messageMngt;
    }

    protected MessageFormat resolveCode(String key, Locale locale) {
        // Utilisation du service pour récuperer le message traduit
        String message = messageMngt.getMessage(key, locale.getLanguage(), locale.getCountry());
        // Et renvoie de celui-ci sous la bonne forme
        return createMessageFormat(message, locale);

    }
}
