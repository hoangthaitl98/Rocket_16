package com.vtii.service;

import com.vtii.entity.Account;
import com.vtii.repository.IRegistrationUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IRegistrationUserTokenRepository registrationUserToken;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendRegistrationUserConfirm(String email) {
        Account account = accountService.getAccountByEmail(email);
        String token = registrationUserToken.findByUserId(account.getId());
        String confirmationUrl = "http://localhost:8080/api/v1/accountRegister/activeUser?token=" + token;
        String subject = "Xac nhan dang ky tai khoan";
        String content = "Ban da dang ky thanh cong. Click vao link duoi day de kich hoat tai khoan \n" + confirmationUrl;
        sendEmail(email, subject, content);
    }

    private void sendEmail(final String recipientEmail, final String subject, final String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
