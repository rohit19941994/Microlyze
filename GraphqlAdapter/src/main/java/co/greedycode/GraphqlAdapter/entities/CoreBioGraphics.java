package co.greedycode.GraphqlAdapter.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "coreBioGraphics")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoreBioGraphics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "personId", nullable = false)
    private Long personId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "dob", nullable = true)
    private String dob;
    @Column(name = "gender", nullable = true)
    private String gender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

}
