package co.greedycode.GraphqlAdapter.resolver;

import co.greedycode.GraphqlAdapter.dto.ServiceInfo;
import co.greedycode.GraphqlAdapter.entities.ContactMethod;
import co.greedycode.GraphqlAdapter.entities.CoreBioGraphics;
import co.greedycode.GraphqlAdapter.entities.Log;
import co.greedycode.GraphqlAdapter.entities.Person;
import co.greedycode.GraphqlAdapter.service.impl.RegistrationServiceImpl;
import co.greedycode.GraphqlAdapter.views.PersonDetails;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Component
@GraphQLApi
public class graphqlResolver {

    private RegistrationServiceImpl registrationService;

    public graphqlResolver(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @GraphQLMutation(name = "registerUser")
    public Optional<PersonDetails> registerUser(
            @GraphQLArgument(name = "person") @Valid @NotNull Person person,
            @Valid @NotNull ContactMethod contactMethod,
            @Valid @NotNull CoreBioGraphics coreBioGraphics
    ) {
        return registrationService.createPerson(person, contactMethod, coreBioGraphics);
    }

    @GraphQLQuery(name = "personDetailsById")
    public Optional<PersonDetails> personById(
            @GraphQLArgument(name = "personId")
            @Valid @NotNull Long id
    ) {
        return registrationService.getPeronById(id);
    }

    @GraphQLQuery(name = "signInUser")
    public Optional<Person> signInUser(
            @GraphQLArgument(name = "email") @Valid @NotNull String email,
            @GraphQLArgument(name = "password") @Valid @NotNull String password
    ) {
        return registrationService.signInUser(email, password);
    }

    @GraphQLMutation(name = "logEvent")
    public Optional<Log> saveLog(
            @GraphQLArgument(name = "log") @Valid @NotNull Object event,
            @GraphQLArgument(name = "serviceInfo") @Valid @NotNull ServiceInfo serviceInfo
    ) {
        return registrationService.saveLog(event, serviceInfo);
    }


}
