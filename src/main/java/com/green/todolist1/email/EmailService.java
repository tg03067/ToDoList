package com.green.todolist1.email;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    @Value("${spring.mail.username}") String from;
    @Value("${spring.mail.password}") String password;
    @Value("${spring.mail.host}") String host;
    private final JavaMailSenderImpl mailSender;
    private final Map<String, String> verificationCodes = new HashMap<>();

    public String generateVerificationCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(100000));
    }

    public void sendVerificationCode(String email) throws MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.debug", "true");

        sender.setJavaMailProperties(props);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        String verificationCode = generateVerificationCode();
        verificationCodes.put(email, verificationCode); //이메일과 인증번호를 맵에 저장

        MimeMessage msg = new MimeMessage(session);
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
        helper.setTo(email);
        helper.setFrom(from);
        helper.setSubject("인증코드");
        helper.setText("당신의 인증번호: " + verificationCode);

        mailSender.send(msg);
        log.info("Verification code for {}: {}", email, verificationCode);  // 디버그용 출력
    }

    public boolean verifyCode(String email, String code) {
        String storedCode = verificationCodes.get(email);
        log.info("Stored code for {}: {}", email, storedCode);
        return storedCode != null && storedCode.equals(code);
    }

    public void clearVerificationCode(String email) {
        verificationCodes.remove(email);
    }
}
