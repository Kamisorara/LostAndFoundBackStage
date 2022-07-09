package com.laf.service.service.impl;



import com.laf.service.service.VerifyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerifyServiceImpl implements VerifyService {

    @Autowired
    JavaMailSender sender;

    @Autowired
    StringRedisTemplate template;

    @Value("${spring.mail.username}")
    String from;

    @Override
    public void sendVerifyCode(String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("【LostAndFound】您的验证密码");
        Random random = new Random();
        int code = random.nextInt(89999) + 10000;
        template.opsForValue().set("verify:code:" + mail, code + "", 3, TimeUnit.MINUTES);
        message.setText("您的注册验证码为: " + code + "\n三分钟内有效!\n请不要回复！");
        message.setTo(mail);
        message.setFrom(from);
        sender.send(message);
    }


    @Override
    public boolean doVerify(String mail, String code) {
        String s = template.opsForValue().get("verify:code:" + mail);
        if (s == null) {
            return false;
        }
        if (!s.equals(code)) {
            return false;
        }
        template.delete("verify:code:" + mail);
        return true;
    }
}
