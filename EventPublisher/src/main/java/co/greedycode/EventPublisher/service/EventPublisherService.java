package co.greedycode.EventPublisher.service;

import co.greedycode.EventPublisher.client.GraphqlClient;
import co.greedycode.EventPublisher.dto.*;
import co.greedycode.EventPublisher.dto.Error;
import co.greedycode.EventPublisher.utils.ServiceInfoUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventPublisherService {

    private final GraphqlClient graphqlClient;
    private final ServiceInfoUtil serviceInfoUtil;

    public EventPublisherService(GraphqlClient graphqlClient, ServiceInfoUtil serviceInfoUtil) {
        this.graphqlClient = graphqlClient;
        this.serviceInfoUtil = serviceInfoUtil;
    }

    public PublisherResponse sendLogEvent(PublisherRequest publisherRequest) throws JsonProcessingException {
        boolean isSent = graphqlClient.sendData(
                publisherRequest.getEventLog(),
                publisherRequest.getServiceInfo()
        );
        PublisherResponse response = new PublisherResponse();
        if(isSent){
            log.info("Event Published successfully");
            response.setSuccessResponseData(
                    new SuccessResponseData(
                            new Status("Event Sent Successfully"),
                            serviceInfoUtil.updateServiceInfo(publisherRequest)
                    )
            );
        }else{
            log.info("Fail to sent event");
            response.setErrorResponseData(
                    new ErrorResponseData(
                            serviceInfoUtil.updateServiceInfo(publisherRequest),
                            new Error(503, "503", "Failed to sent Event, Please check again")
                    )
            );
        }

        return response;
    }
}
