package com.example.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = new ClassPathXmlApplicationContext("configci.xml");
        Abc s1= context.getBean("student1", Abc.class);
        System.out.println(s1);
    }
}
