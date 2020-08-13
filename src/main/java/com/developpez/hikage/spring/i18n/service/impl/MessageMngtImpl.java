package com.developpez.hikage.spring.i18n.service.impl;

import com.developpez.hikage.spring.i18n.service.MessageMngt;
import com.developpez.hikage.spring.i18n.dao.MessageDao;


public class MessageMngtImpl implements MessageMngt {

    // Propriété pour connaitre  
    private String langueDefaut = "fr";

    // DAO pour les message
    private MessageDao messageDao;

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    // Setter de la langue par défaut
    public void setLangueDefaut(String langueDefaut) {
        this.langueDefaut = langueDefaut;
    }

    public String getMessage(String cle, String langue, String pays) {

        // Si un message pour la locale complète existe
        String message = messageDao.getMessage(cle, langue, pays);
        // On le renvoit
        if (message != null) return message;

        // Sinon on cherche un message basé sur la langue uniquement
        message = messageDao.getMessage(cle, langue);
        // Et on le retourne si il y en a un
        if (message != null) return message;

        // Sinon on cherche un message dans la langue par defaut
        message = messageDao.getMessage(cle, langueDefaut);
        if (message != null) return message;

        // Si le message n'existe pas on renvoit une chaine spéciale
        return "???" + cle + "???";
    }

}
