package co.greedycode.GraphqlAdapter.views;

import co.greedycode.GraphqlAdapter.entities.ContactMethod;
import co.greedycode.GraphqlAdapter.entities.CoreBioGraphics;
import co.greedycode.GraphqlAdapter.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {
    private Person person;
    private CoreBioGraphics coreBioGraphics;
    private ContactMethod contactMethod;

}
