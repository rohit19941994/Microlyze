package co.greedycode.GraphqlAdapter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceInfo {
    private String origin;
    private String service;
    private String timestamp;
    private String activity;
}
