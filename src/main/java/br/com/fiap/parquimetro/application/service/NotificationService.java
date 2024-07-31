package br.com.fiap.parquimetro.application.service;

import br.com.fiap.parquimetro.application.port.in.NotificationPortIn;
import br.com.fiap.parquimetro.application.port.out.ParkingPortOut;
import br.com.fiap.parquimetro.application.port.out.SendingEmailPortOut;
import br.com.fiap.parquimetro.domain.enums.ParkingStatus;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class NotificationService implements NotificationPortIn {

    @Autowired
    ParkingPortOut parkingPortOut;

    @Autowired
    SendingEmailPortOut sendingEmailPortOut;

    @Override
    public void sending() {

        var parkResults = parkingPortOut.searchAllParking();

        if(parkResults.isEmpty()) {
            log.warn("### LOADING - There are no cars with expired time ###");
        } else {
            parkResults.forEach(pr -> {

                if(pr.getParkingStatus().equals(ParkingStatus.EXPIRED)) {

                    sendingEmailPortOut.sendEmail(pr.getDriverCollection());

                }

            });
        }


    }

    @Override
    public void verify() {

        var parkResults = parkingPortOut.searchAllParking();

        if(parkResults.isEmpty()) {
            log.warn("### LOADING - There are no cars in the parking lot ###");
        } else {
            parkResults.forEach(pr -> {

                if(pr.getDepartureTime().isBefore(LocalDateTime.now())) {

                    log.info("Expired client: {}", pr.getDriverCollection().getName());
                    pr.setParkingStatus(ParkingStatus.EXPIRED);
                    parkingPortOut.updateParking(pr);

                }

            });
        }

    }
}
