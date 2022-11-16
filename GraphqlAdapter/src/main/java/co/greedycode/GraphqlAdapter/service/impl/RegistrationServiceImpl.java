package co.greedycode.GraphqlAdapter.service.impl;

import co.greedycode.GraphqlAdapter.dto.ServiceInfo;
import co.greedycode.GraphqlAdapter.entities.ContactMethod;
import co.greedycode.GraphqlAdapter.entities.CoreBioGraphics;
import co.greedycode.GraphqlAdapter.entities.Log;
import co.greedycode.GraphqlAdapter.entities.Person;
import co.greedycode.GraphqlAdapter.repository.ContactMethodRepo;
import co.greedycode.GraphqlAdapter.repository.CoreBioGraphicsRepo;
import co.greedycode.GraphqlAdapter.repository.LogRepo;
import co.greedycode.GraphqlAdapter.repository.PersonRepo;
import co.greedycode.GraphqlAdapter.service.RegistrationService;
import co.greedycode.GraphqlAdapter.util.ServiceInfoUtil;
import co.greedycode.GraphqlAdapter.views.PersonDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

    private final PersonRepo personRepo;
    private final ContactMethodRepo contactMethodRepo;
    private final CoreBioGraphicsRepo coreBioGraphicsRepo;
    private final LogRepo logRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ServiceInfoUtil serviceInfoUtil;
    private final ObjectMapper objectMapper;

    public RegistrationServiceImpl(PersonRepo personRepo, ContactMethodRepo contactMethodRepo, CoreBioGraphicsRepo coreBioGraphicsRepo, LogRepo logRepo, BCryptPasswordEncoder bCryptPasswordEncoder, ServiceInfoUtil serviceInfoUtil, ObjectMapper objectMapper) {
        this.personRepo = personRepo;
        this.contactMethodRepo = contactMethodRepo;
        this.coreBioGraphicsRepo = coreBioGraphicsRepo;
        this.logRepo = logRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.serviceInfoUtil = serviceInfoUtil;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public Optional<PersonDetails> createPerson(
            Person person,
            ContactMethod contactMethod,
            CoreBioGraphics coreBioGraphics
    ) {
        PersonDetails personDetails = new PersonDetails();
        try {
            person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
            Person savedPerson = personRepo.save(person);
            contactMethod.setPersonId(savedPerson.getId());
            contactMethodRepo.save(contactMethod);
            coreBioGraphics.setPersonId(savedPerson.getId());
            coreBioGraphicsRepo.save(coreBioGraphics);
            personDetails.setPerson(person);
            personDetails.setContactMethod(contactMethod);
            personDetails.setCoreBioGraphics(coreBioGraphics);
        } catch (Exception err) {
            log.info("Error while creating the Person");
        }
        return Optional.of(personDetails);
    }

    @Override
    public Optional<PersonDetails> getPeronById(Long id) {
        PersonDetails personDetails = new PersonDetails();
        Person person = personRepo.findById(id).get();
        ContactMethod contactMethod = contactMethodRepo.findByPersonId(person.getId()).get();
        CoreBioGraphics coreBioGraphics = coreBioGraphicsRepo.findByPersonId(person.getId()).get();

        return Optional.of(new PersonDetails(person, coreBioGraphics, contactMethod));
    }

    @Override
    public Optional<Person> signInUser(String email, String password) {
        Optional<Person> person = personRepo.findByEmail(email);
        boolean isMatched = bCryptPasswordEncoder.matches(password, person.get().getPassword());
        if (isMatched) {
            return person;
        } else {
            return null;
        }
    }

    @Override
    public Optional<Log> saveLog(Object event, ServiceInfo serviceInfo) {
        Log savedLog = new Log();
        try {
            savedLog = logRepo.save(
                    new Log(
                            objectMapper.writeValueAsString(event),
                            String.valueOf(LocalDateTime.now()),
                            serviceInfoUtil.getService(serviceInfo),
                            serviceInfoUtil.getTimeStamp(serviceInfo)
                    )
            );
            log.info("Log Saved");
        } catch (Exception err) {
            log.info("Failed to save the Log: " + err.getLocalizedMessage());
        }
        return Optional.of(savedLog);
    }
}
