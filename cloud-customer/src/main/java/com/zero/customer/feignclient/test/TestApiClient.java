package com.zero.customer.feignclient.test;

import com.zero.customer.feignclient.BaseApi;
import com.zero.manager.api.TestApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(BaseApi.CLOUD_MANAGER)
public interface TestApiClient extends TestApi {
}
