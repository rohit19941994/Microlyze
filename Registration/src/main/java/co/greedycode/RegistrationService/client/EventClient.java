package co.greedycode.RegistrationService.client;

import co.greedycode.RegistrationService.dto.EventPublisherRequest;
import co.greedycode.RegistrationService.dto.RegistrationRequest;
import co.greedycode.RegistrationService.utils.ServiceInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EventClient {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${event.publisher.url}")
    private String eventUrl;

    private final RestTemplate restTemplate;
    private final ServiceInfoUtil serviceInfoUtil;

    public EventClient(RestTemplate restTemplate, ServiceInfoUtil serviceInfoUtil) {
        this.restTemplate = restTemplate;
        this.serviceInfoUtil = serviceInfoUtil;
    }

    public boolean sendEvent(RegistrationRequest registrationRequest) {
        registrationRequest.getRequestData().setServiceInfo(serviceInfoUtil.updateServiceInfo(registrationRequest));
        boolean isSent = false;
        EventPublisherRequest request = new EventPublisherRequest(
                registrationRequest,
                registrationRequest.getRequestData().getServiceInfo()
        );
        try {
            // Responsible for sending data to Graphql using rest template
            ResponseEntity<Object> restResponse =
                    restTemplate.postForEntity(eventUrl, request, Object.class);
            log.info("Data Sent successfully over rest template");
            isSent = true;
        } catch (Exception er) {
            log.info("Failed to publish event: " + er.getLocalizedMessage());
        }
        return isSent;
    }
}
