package co.greedycode.EventPublisher.client;

public interface GraphqlMutation {

    String LOG_EVENT_MUTATION = "\"" +
            "mutation($log:ObjectScalar!, $serviceInfo:ServiceInfoInput!){\n" +
            "  logEvent(log:$log, serviceInfo:$serviceInfo){\n" +
            "    logs\n" +
            "  }\n" +
            "}" +
            "\"";
}
