package co.greedycode.RegistrationService.service;

import co.greedycode.RegistrationService.client.EventClient;
import co.greedycode.RegistrationService.client.GraphqlClient;
import co.greedycode.RegistrationService.dto.*;
import co.greedycode.RegistrationService.utils.ServiceInfoUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("default")
public class RegistrationServiceTest {

    @MockBean
    private EventClient eventClient;
    @MockBean
    private GraphqlClient graphqlClient;
    @MockBean
    private ServiceInfoUtil serviceInfoUtil;

    private RegistrationService registrationService;

    @BeforeEach
    public void setUp(){
        registrationService = new RegistrationService(eventClient, graphqlClient, serviceInfoUtil);
    }

    @Test
    public void signInUser_ShouldReturnSuccessResponse_WhenEmailAndPasswordGiven(){
        // GIVEN
        RegistrationRequest registrationRequest = createMockRegistrationRequest();
        when(eventClient.sendEvent(registrationRequest)).thenReturn(true);
        when(graphqlClient.signInUser(getNaturalPerson())).thenReturn(true);

        // WHEN
        RegistrationResponse response = registrationService.authenticateUser(registrationRequest);

        // THEN
        assertNotNull(response);
        assertNull(response.getErrorResponseData());
        assertNotNull(response.getSuccessResponseData());
    }

    @Test
    public void signUpUser_ShouldReturnSuccessResponse_whenAvailableDataGiven() throws JsonProcessingException {
        // GIVEN
        RegistrationRequest registrationRequest = createMockRegistrationRequest();
        when(eventClient.sendEvent(registrationRequest)).thenReturn(true);
        when(graphqlClient.signUpUser(registrationRequest)).thenReturn(true);

        // WHEN
        RegistrationResponse response = registrationService.registerUser(registrationRequest);

        // THEN
        assertNotNull(response);
        assertNull(response.getErrorResponseData());
        assertNotNull(response.getSuccessResponseData());

    }

    private RegistrationRequest createMockRegistrationRequest(){
        return new RegistrationRequest(
                getRequestData()
        );
    }

    private RequestData getRequestData(){
        return new RequestData(
                getPerson(),
                getServiceInfo(),
                getContactMethod()
        );
    }

    private Person getPerson(){
        return new Person(
                getNaturalPerson(),
                getCoreBioGraphics()
        );
    }

    private NaturalPerson getNaturalPerson(){
        return new NaturalPerson(
                "feezanktk2208@gmail.com",
                "test123"
        );
    }

    private CoreBioGraphic getCoreBioGraphics(){
        return new CoreBioGraphic(
                "Feezan",
                "khattak",
                "22 Aug, 1996",
                "MALE"
        );
    }

    private ServiceInfo getServiceInfo(){
        return new ServiceInfo(
                "Postman",
                "Registration",
                "11 May, 2001 5564",
                "Registration"
        );
    }

    private ContactMethod getContactMethod(){
        return new ContactMethod(
                "0315973648",
                "92"
        );
    }
}
