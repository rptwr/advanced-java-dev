package com.example.microServicesapp3OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="microServices-app4-server", url = "http://localhost:8091")
public interface ProxyForApp4Server {
	
	@RequestMapping("/test1")
	public String callTest1();

}
