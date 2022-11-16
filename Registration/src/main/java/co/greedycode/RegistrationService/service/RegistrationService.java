package co.greedycode.RegistrationService.service;


import co.greedycode.RegistrationService.client.EventClient;
import co.greedycode.RegistrationService.client.GraphqlClient;
import co.greedycode.RegistrationService.dto.*;
import co.greedycode.RegistrationService.dto.Error;
import co.greedycode.RegistrationService.utils.ServiceInfoUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationService {

    private final EventClient eventClient;
    private final GraphqlClient graphqlClient;

    private final ServiceInfoUtil serviceInfoUtil;

    public RegistrationService(EventClient eventClient, GraphqlClient graphqlClient, ServiceInfoUtil serviceInfoUtil) {
        this.eventClient = eventClient;
        this.graphqlClient = graphqlClient;
        this.serviceInfoUtil = serviceInfoUtil;
    }

    public RegistrationResponse authenticateUser(RegistrationRequest registrationRequest) {
        boolean isSent = eventClient.sendEvent(registrationRequest);
        if(isSent){
            log.info("Event Sent successfully");
        }
        RegistrationResponse response = new RegistrationResponse();
        if(registrationRequest.getRequestData() != null){
            boolean isAuthenticated = graphqlClient.signInUser(
                    registrationRequest.getRequestData().getPerson().getNaturalPerson());
            if(isAuthenticated){
                response.setSuccessResponseData(
                        new SuccessResponseData(
                                new Status("User Authenticated"),
                                serviceInfoUtil.updateServiceInfo(registrationRequest)
                        )
                );
            }else{
                response.setErrorResponseData(
                        new ErrorResponseData(
                                serviceInfoUtil.updateServiceInfo(registrationRequest),
                                new Error(404, "404", "User not found!")
                        )
                );
            }
        }
        return response;
    }

    public RegistrationResponse registerUser(RegistrationRequest registrationRequest) throws JsonProcessingException {
        boolean isSent = eventClient.sendEvent(registrationRequest);
        if(isSent){
            log.info("Event Sent successfully");
        }
        RegistrationResponse response = new RegistrationResponse();
        if(registrationRequest.getRequestData() != null){
            boolean isRegistered = graphqlClient.signUpUser(registrationRequest);
            if(isRegistered){
                response.setSuccessResponseData(
                        new SuccessResponseData(
                                new Status("User Registered Successfully"),
                                serviceInfoUtil.updateServiceInfo(registrationRequest)
                        )
                );
            }else{
                response.setErrorResponseData(
                        new ErrorResponseData(
                                serviceInfoUtil.updateServiceInfo(registrationRequest),
                                new Error(404, "404", "Fail to register user, Please provide correct data")
                        )
                );
            }
        }
        return response;
    }
}
