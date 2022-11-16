package co.greedycode.RegistrationService.utils;

import co.greedycode.RegistrationService.dto.RegistrationRequest;
import co.greedycode.RegistrationService.dto.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Slf4j
public class ServiceInfoUtil {
    @Value("${spring.application.name}")
    private String applicationName;

    public ServiceInfo updateServiceInfo(RegistrationRequest registrationRequest) {
        ServiceInfo serviceInfo = registrationRequest.getRequestData().getServiceInfo();
        if (serviceInfo != null) {
            serviceInfo.setService(applicationName);
            serviceInfo.setOrigin(applicationName);
            serviceInfo.setTimestamp(String.valueOf(LocalDateTime.now()));
        } else {
            log.info("Incomplete Service info detected");
        }

        return serviceInfo;

    }
}
