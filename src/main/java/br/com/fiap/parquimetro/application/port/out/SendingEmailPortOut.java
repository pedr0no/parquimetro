package br.com.fiap.parquimetro.application.port.out;

import br.com.fiap.parquimetro.domain.entity.DriverEntity;

public interface SendingEmailPortOut {

    void sendEmail(DriverEntity driverCollection);

}
