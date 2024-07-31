package br.com.fiap.parquimetro.framework.adapter.in.scheduler;

import br.com.fiap.parquimetro.application.port.in.NotificationPortIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ParkingScheduler {

    @Autowired
    NotificationPortIn portIn;

    @Scheduled(cron = "0 0/5 * 1/1 * ?")
    public void scheduleEmailSending(){
        portIn.sending();
    }

    @Scheduled(cron = "0 0/5 * 1/1 * ?")
    public void scheduleParkingVerify(){
        portIn.verify();
    }

}
