package co.greedycode.EventPublisher.client;

import co.greedycode.EventPublisher.dto.GraphqlDaoResponse;
import co.greedycode.EventPublisher.dto.ServiceInfo;
import co.greedycode.EventPublisher.utils   .GraphqlNullChecker;
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

import static co.greedycode.EventPublisher.client.GraphqlMutation.LOG_EVENT_MUTATION;

@Service
@Slf4j
public class GraphqlClient {

    @Value("${graphql.url}")
    private String graphqlUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final GraphqlNullChecker nullChecker;

    public GraphqlClient(RestTemplate restTemplate, ObjectMapper objectMapper, GraphqlNullChecker nullChecker) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.nullChecker = nullChecker;
    }

    public boolean sendData(Object event, ServiceInfo serviceInfo) throws JsonProcessingException {

        String QUERY = "{\"query\": " + LOG_EVENT_MUTATION + ", \"variables\": {" +
                "\"log\": " + objectMapper.writeValueAsString(event) + "," +
                "\"serviceInfo\": " + objectMapper.writeValueAsString(serviceInfo)+ "}}";
        boolean isSent = false;
        try {
            Gson gson = new Gson();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JsonReader reader = new JsonReader(new StringReader(QUERY.trim()));
            reader.setLenient(true);
            Object json = gson.fromJson(reader, Object.class);
            HttpEntity<Object> entity = new HttpEntity<>(json, headers);
            ResponseEntity<GraphqlDaoResponse> restResponse = restTemplate.postForEntity(graphqlUrl, entity, GraphqlDaoResponse.class);
            if (nullChecker.isLogNullable(restResponse.getBody())) {
                isSent = true;
                log.info("Event Send to Dao Successfully");
            }
        } catch (Exception er) {
            log.info("Failed To sent query: " + er.getLocalizedMessage());
        }
        return isSent;
    }
}
