package com.fsk.controller;

import com.fsk.config.EmailCfg;
import com.fsk.models.Content;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/mail")
@AllArgsConstructor
public class MailController {

    private final EmailCfg emailCfg;

    @PostMapping("/send")
    public void sendEmail(@RequestBody Content content,
                          BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationException("Mail is not valid.!");
        }

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUserName());
        mailSender.setPassword(this.emailCfg.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(content.getEmail());
        mailMessage.setTo("fsk@gmail.com");
        mailMessage.setSubject("New Message From: " + content.getName());
        mailMessage.setSubject(content.getContent());

        mailSender.send(mailMessage);
    }

}
