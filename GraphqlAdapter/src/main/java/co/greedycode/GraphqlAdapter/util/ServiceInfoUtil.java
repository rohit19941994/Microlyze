package co.greedycode.GraphqlAdapter.util;
import co.greedycode.GraphqlAdapter.dto.ServiceInfo;
import org.springframework.stereotype.Component;

@Component
public class ServiceInfoUtil {

    public String getService(ServiceInfo serviceInfo){
        return serviceInfo.getService();
    }

    public String getTimeStamp(ServiceInfo serviceInfo){
        return serviceInfo.getTimestamp();
    }

    public String getActivity(ServiceInfo serviceInfo){
        return serviceInfo.getActivity();
    }
}
