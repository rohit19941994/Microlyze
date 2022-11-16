package co.greedycode.RegistrationService.client;

public interface GraphqlMutation {

    String SIGNIN_USER_MUTATION = "\"" +
            "query($email:String!, $password: String!){\n" +
            "  signInUser(email:$email, password: $password){\n" +
            "    id\n" +
            "  }\n" +
            "}" +
            "\"";

    String SIGNUP_USER_MUTATION = "\"" +
            "mutation($person: PersonInput!, $coreBioGraphics: CoreBioGraphicsInput!,  $contactMethod: ContactMethodInput!){\n" +
            "  registerUser(person: $person, coreBioGraphics:$coreBioGraphics, contactMethod:$contactMethod){\n" +
            "    person{\n" +
            "      id\n" +
            "    }\n" +
            "  }\n" +
            "}" +
            "\"";
}