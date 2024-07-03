package ynu.edu.rule;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

public class CustomerThreeTimesLoadBalancer {
    @Bean
    ReactorLoadBalancer<ServiceInstance> threeTimesLoadBalancer(Environment envir, LoadBalancerClientFactory lbcf) {
        String name = envir.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);

        return new ThreeTimesLoadBalancer(lbcf.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
    }
}
