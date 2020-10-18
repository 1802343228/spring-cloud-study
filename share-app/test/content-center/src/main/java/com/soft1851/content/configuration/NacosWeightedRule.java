package com.soft1851.content.configuration;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author crq
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    private final NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //读取配置文件，并初始化NacosWeightRule
    }

    @Override
    public Server choose(Object o) {
        try{
            BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer)this.getLoadBalancer();

            //请求的服务名称
            String name = baseLoadBalancer.getName();

            //拿到服务发现的相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();

            //nacos client自动通过基于权重的负载均衡算法，给我们一个实例
            Instance instance = namingService.selectOneHealthyInstance(name);

            log.info("选择的实例是：port = {},instance = {}",instance.getPort(),instance);
            return new NacosServer(instance);
        }catch (NacosException e) {
            return null;
        }
    }
}
