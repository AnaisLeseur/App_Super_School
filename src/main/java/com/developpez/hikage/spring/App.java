package com.developpez.hikage.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("HelloWorld en français de France : " + applicationContext.getMessage("helloWorld", null, Locale.FRANCE));
        System.out.println("HelloWorld en Belge : " + applicationContext.getMessage("helloWorld", null, new Locale("fr", "BE")));
        System.out.println("HelloWorld Italie : " + applicationContext.getMessage("helloWorld", null, Locale.ITALY));

    }
}
