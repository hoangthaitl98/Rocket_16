package com.vtii.event;

import com.vtii.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SendRegistrationUserConfirmViaEmailListener implements
        ApplicationListener<OnRegistrationUserConfirmViaEmailEvent> {

    @Autowired
    private IEmailService emailService;

    @Override
    public void onApplicationEvent(OnRegistrationUserConfirmViaEmailEvent event) {
        sendConfirmViaEmail(event.getEmail());
    }

    private void sendConfirmViaEmail(String email){
        emailService.sendRegistrationUserConfirm(email);
    }
}
