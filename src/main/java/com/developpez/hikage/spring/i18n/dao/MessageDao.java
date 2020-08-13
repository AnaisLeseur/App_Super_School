package com.developpez.hikage.spring.i18n.dao;


public interface MessageDao {

    public String getMessage(String cle, String langue, String pays);

    public String getMessage(String cle, String langue);
}
