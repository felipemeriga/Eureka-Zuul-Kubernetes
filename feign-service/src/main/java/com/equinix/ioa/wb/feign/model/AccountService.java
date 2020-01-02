package com.equinix.ioa.wb.feign.model;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "account-service")
public interface AccountService {
    @RequestMapping(value = "account/feign", method = RequestMethod.GET)
    String feignMethod();
}
