package co.greedycode.GraphqlAdapter.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "contactMethod")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "personId", nullable = false)
    private Long personId;
    @Column(name = "mobile_number", nullable = true)
    private String mobileNumber;
    @Column(name = "country_code", nullable = true)
    private String countryCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

}
