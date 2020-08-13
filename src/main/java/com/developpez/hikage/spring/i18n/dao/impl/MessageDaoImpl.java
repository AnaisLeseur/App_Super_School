package com.developpez.hikage.spring.i18n.dao.impl;

import com.developpez.hikage.spring.i18n.dao.MessageDao;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


public class MessageDaoImpl extends JdbcDaoSupport implements MessageDao {

    public String getMessage(String cle, String langue, String pays) {

        List<String> result = getJdbcTemplate().query("SELECT texte FROM messages WHERE `key` = ? AND langue = ? and pays = ?", new Object[]{cle, langue, pays}, new SingleColumnRowMapper(String.class));
        if (result.size() == 1) return result.get(0);
        else return null;


    }

    public String getMessage(String cle, String langue) {
        List<String> result = getJdbcTemplate().query("SELECT texte FROM messages WHERE `key` = ? AND langue = ? and pays is null", new Object[]{cle, langue}, new SingleColumnRowMapper(String.class));

        if (result.size() == 1) return result.get(0);
        else return null;
    }
}
