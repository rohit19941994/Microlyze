package co.greedycode.GraphqlAdapter.service;

import co.greedycode.GraphqlAdapter.dto.ServiceInfo;
import co.greedycode.GraphqlAdapter.entities.ContactMethod;
import co.greedycode.GraphqlAdapter.entities.CoreBioGraphics;
import co.greedycode.GraphqlAdapter.entities.Log;
import co.greedycode.GraphqlAdapter.entities.Person;
import co.greedycode.GraphqlAdapter.views.PersonDetails;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface RegistrationService {

    Optional<PersonDetails> createPerson(Person person, ContactMethod contactMethod, CoreBioGraphics coreBioGraphics);
    Optional<PersonDetails> getPeronById(Long id);

    Optional<Person> signInUser(String email, String password);

    Optional<Log> saveLog(Object event, ServiceInfo serviceInfo) throws JsonProcessingException;
}
