package com.green.todolist1.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") static String from;
    @Value("${spring.mail.password}") static String password;
    @Value("${spring.mail.host}") static String host;

    public static void main(String[] args) throws Exception{
        String to;
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", host);
    }
}
