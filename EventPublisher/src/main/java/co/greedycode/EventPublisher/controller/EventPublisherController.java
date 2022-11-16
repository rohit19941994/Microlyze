
package co.greedycode.EventPublisher.controller;

import co.greedycode.EventPublisher.dto.PublisherRequest;
import co.greedycode.EventPublisher.dto.PublisherResponse;
import co.greedycode.EventPublisher.service.EventPublisherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventPublisherController {

    private final EventPublisherService eventPublisherService;

    public EventPublisherController(EventPublisherService eventPublisherService) {
        this.eventPublisherService = eventPublisherService;
    }

    @CrossOrigin
    @PostMapping("/logEvent")
    ResponseEntity<PublisherResponse> logEvent(@RequestBody @Valid PublisherRequest publisherRequest) throws JsonProcessingException {
        return ResponseEntity.ok(eventPublisherService.sendLogEvent(publisherRequest));
    }
}
