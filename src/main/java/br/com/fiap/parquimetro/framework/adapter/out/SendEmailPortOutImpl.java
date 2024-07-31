package br.com.fiap.parquimetro.framework.adapter.out;

import br.com.fiap.parquimetro.application.port.out.SendingEmailPortOut;
import br.com.fiap.parquimetro.domain.entity.DriverEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailPortOutImpl implements SendingEmailPortOut {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${parquimetro.email-noreply}")
    private String email;

    @Override
    public void sendEmail(DriverEntity driverCollection) {

        var message = new SimpleMailMessage();
        log.info("Sending email");
        message.setFrom(email);
        message.setTo(driverCollection.getEmail());
        message.setSubject(driverCollection.getName());
        message.setText("Tempo limite do parquimetro excedido, por favor realizar nova recarga.");

        javaMailSender.send(message);

    }
}
