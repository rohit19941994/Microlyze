package co.greedycode.GraphqlAdapter.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name="logs", nullable = false, columnDefinition = "BLOB")
    private String logs;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "service")
    private String service;

    @Column(name = "timestamp")
    private String timestamp;

    public Log(String logs, String createdAt, String service, String timestamp) {
        this.logs = logs;
        this.createdAt = createdAt;
        this.service = service;
        this.timestamp = timestamp;
    }
}
