package co.greedycode.RegistrationService.controller;

import co.greedycode.RegistrationService.dto.RegistrationRequest;
import co.greedycode.RegistrationService.dto.RegistrationResponse;
import co.greedycode.RegistrationService.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @CrossOrigin
    @PostMapping("/signIn")
    ResponseEntity<RegistrationResponse> signInUser(
            @RequestBody @Valid @NotNull RegistrationRequest registrationRequest
    ){
        return ResponseEntity.ok(registrationService.authenticateUser(registrationRequest));
    }

    @CrossOrigin
    @PostMapping("/signUp")
    ResponseEntity<RegistrationResponse> signUpUser(
            @RequestBody @Valid @NotNull RegistrationRequest registrationRequest
    ) throws JsonProcessingException {
        return ResponseEntity.ok(registrationService.registerUser(registrationRequest));
    }
}
