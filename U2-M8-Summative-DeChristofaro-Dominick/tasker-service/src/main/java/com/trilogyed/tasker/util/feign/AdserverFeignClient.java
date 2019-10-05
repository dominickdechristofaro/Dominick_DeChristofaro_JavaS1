package com.trilogyed.tasker.util.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "adserver-service")
public interface AdserverFeignClient {

    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    String getAd();
}
