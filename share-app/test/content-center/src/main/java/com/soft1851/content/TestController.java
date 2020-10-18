package com.soft1851.content;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.soft1851.content.dto.UserDto;
import com.soft1851.content.feignclient.TestBaiduFeignClient;
import com.soft1851.content.feignclient.TestUserCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author crq
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class TestController {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final TestUserCenterFeignClient testUserCenterFeignClient;
    private final TestBaiduFeignClient testBaiduFeignClient;

    @GetMapping("/discovery")
    public List<ServiceInstance> getInstances(){
        //查询指定服务的所有实例信息
        return this.discoveryClient.getInstances("user-center");
    }

    @GetMapping(value = "/call/hello")
    public String callUserCenter(){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        ServiceInstance serviceInstance = instances.get(new Random().nextInt(instances.size()));
        String targetUrl = serviceInstance.getUri() + "/user/hello";
//        String targetUrl = instances.stream()
//                .map(instance -> instance.getUri().toString()+"/user/hello")
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("当前没有实例"));
        log.info("请求的目标地址：{}",targetUrl);
        return restTemplate.getForObject(targetUrl,String.class);
    }

    @GetMapping(value = "/call/ribbon")
    public String callByRibbon() {
        return  restTemplate.getForObject("http://user-center/user/hello",String.class);
    }

    @GetMapping(value = "/test-q")
    public UserDto query(UserDto userDto){
        return testUserCenterFeignClient.query(userDto);
    }

    @GetMapping(value = "/baidu")
    public String baiduIndex() {
        return this.testBaiduFeignClient.index();
    }

    private final TestService testService;

    @GetMapping("/test-a")
    public String testA() {
        this.testService.commonMethod();
        return "test-a";
    }
    @GetMapping("/test-b")
    public String testB() {
        this.testService.commonMethod();
        return "test-b";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public String byResource() {
        return "按名称限流";
    }

    public String handleException(BlockException blockException) {
        return "服务不可用";
    }

}
