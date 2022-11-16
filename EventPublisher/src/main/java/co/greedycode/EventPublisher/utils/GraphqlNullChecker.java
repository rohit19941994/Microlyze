package co.greedycode.EventPublisher.utils;

import co.greedycode.EventPublisher.dto.GraphqlDaoResponse;
import org.springframework.stereotype.Component;

@Component
public class GraphqlNullChecker {

    public boolean isLogNullable(GraphqlDaoResponse graphqlDaoResponse) {
        return graphqlDaoResponse != null &&
                graphqlDaoResponse.getData() != null &&
                graphqlDaoResponse.getData().getLogEvent() != null &&
                graphqlDaoResponse.getData().getLogEvent().getLogs() != null;
    }
}

