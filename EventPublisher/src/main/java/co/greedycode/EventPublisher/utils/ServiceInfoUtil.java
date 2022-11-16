package co.greedycode.EventPublisher.utils;

import co.greedycode.EventPublisher.dto.PublisherRequest;
import co.greedycode.EventPublisher.dto.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class ServiceInfoUtil {

    @Value("${spring.application.name}")
    private String applicationName;

    public ServiceInfo updateServiceInfo(PublisherRequest publisherRequest) {
        assert publisherRequest != null;
        ServiceInfo serviceInfo = publisherRequest.getServiceInfo();
        if (serviceInfo != null) {
            serviceInfo.setService(applicationName);
            serviceInfo.setOrigin(applicationName);
            serviceInfo.setTimestamp(String.valueOf(LocalDateTime.now()));
        }
        return serviceInfo;
    }
}
