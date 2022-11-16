package co.greedycode.RegistrationService.client;

import co.greedycode.RegistrationService.dto.GraphQlResponse;
import co.greedycode.RegistrationService.dto.NaturalPerson;
import co.greedycode.RegistrationService.dto.RegistrationRequest;
import co.greedycode.RegistrationService.utils.GraphqlNullChecker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;

import static co.greedycode.RegistrationService.client.GraphqlMutation.SIGNIN_USER_MUTATION;
import static co.greedycode.RegistrationService.client.GraphqlMutation.SIGNUP_USER_MUTATION;

@Service
@Slf4j
public class GraphqlClient {

    @Value("${signIn.graphql.url}")
    private String signInUrl;

    @Value("${signUp.graphql.url}")
    private String signUpUrl;
    private final RestTemplate restTemplate;
    private final GraphqlNullChecker nullChecker;
    private final ObjectMapper objectMapper;

    public GraphqlClient(RestTemplate restTemplate, GraphqlNullChecker nullChecker, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.nullChecker = nullChecker;
        this.objectMapper = objectMapper;
    }

    public boolean signInUser(NaturalPerson naturalPerson) {
        final String QUERY = "{\"query\": " +SIGNIN_USER_MUTATION+ ", \"variables\": {" +
                "\"email\": \"" +naturalPerson.getEmail()+ "\"," +
                "\"password\": \"" +naturalPerson.getPassword()+ "\"" +
                " }" +
                "}";

        log.info("query: " + QUERY);

        boolean isSent = false;
        try {
            Gson gson = new Gson();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JsonReader reader = new JsonReader(new StringReader(QUERY.trim()));
            reader.setLenient(true);
            Object json = gson.fromJson(reader, Object.class);
            HttpEntity<Object> entity = new HttpEntity<>(json, headers);
            ResponseEntity<GraphQlResponse> restResponse = restTemplate.postForEntity(signInUrl, entity, GraphQlResponse.class);
            log.info("response: " + restResponse);
            if (nullChecker.isSignIn(restResponse.getBody())) {
                isSent = true;
                log.info("query Send to Dao Successfully");
            }
        } catch (Exception er) {
            log.info("Failed To sent query: " + er.getLocalizedMessage());
        }
        return isSent;
    }

    public boolean signUpUser(RegistrationRequest registrationRequest) throws JsonProcessingException {
        final String QUERY = "{\"query\": " +SIGNUP_USER_MUTATION+ ", \"variables\": {" +
                "\"person\": " +objectMapper.writeValueAsString(registrationRequest.getRequestData().getPerson().getNaturalPerson())+ "," +
                "\"contactMethod\": " +objectMapper.writeValueAsString(registrationRequest.getRequestData().getContactMethod())+ "," +
                "\"coreBioGraphics\": " +objectMapper.writeValueAsString(registrationRequest.getRequestData().getPerson().getCoreBioGraphic())+ "}}";

        boolean isSent = false;
        try {
            Gson gson = new Gson();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JsonReader reader = new JsonReader(new StringReader(QUERY.trim()));
            reader.setLenient(true);
            Object json = gson.fromJson(reader, Object.class);
            HttpEntity<Object> entity = new HttpEntity<>(json, headers);
            ResponseEntity<GraphQlResponse> restResponse = restTemplate.postForEntity(signInUrl, entity, GraphQlResponse.class);
            if (nullChecker.isSignUp(restResponse.getBody())) {
                isSent = true;
                log.info("Query Send to Dao Successfully");
            }
        } catch (Exception er) {
            log.info("Failed To sent query: " + er.getLocalizedMessage());
        }
        return isSent;
    }
}
