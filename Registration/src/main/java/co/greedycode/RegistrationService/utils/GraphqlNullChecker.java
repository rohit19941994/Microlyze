package co.greedycode.RegistrationService.utils;

import co.greedycode.RegistrationService.dto.GraphQlResponse;
import org.springframework.stereotype.Component;

@Component
public class GraphqlNullChecker {

    public boolean isSignIn(GraphQlResponse graphqlDaoResponse) {
        return graphqlDaoResponse != null &&
                graphqlDaoResponse.getData() != null &&
                graphqlDaoResponse.getData().getSignInUser() != null;
    }

    public boolean isSignUp(GraphQlResponse graphQlResponse){
        return graphQlResponse != null &&
                graphQlResponse.getData() != null &&
                graphQlResponse.getData().getRegisterUser() != null;
    }
}

