package com.zero.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = GateWayProperties.PREFIX)
public class GateWayProperties {
    public static final String PREFIX = "cloud.gateway";

    /**
     * 忽略登录的url，支持ant style的url
     */
    private Set<String> ignoreLoginUrls;

    /**
     * 不需要解密的url，支持ant style的url
     */
    private Set<String> ignoreDecryptUrls;

    /**
     * 不需要加密的url
     */
    private Set<String> ignoreEncryptUrls;

    /**
     * 允许跨域的源
     */
    private List<String> allowedOrigins;

    /**
     * 为指定的serviceId，设置请求限制规则，注意：此Map的key就是serviceId
     */
    private Map<String, RequestLimit> requestLimit = new HashMap<>();

    /**
     * 默认请求限制
     */
    private RequestLimit defaultRequestLimit;

    /**
     * 封IP的时长，单位为秒
     */
    private int ipLimitExpire;

    /**
     * 请求次数限制配置
     */
    @Data
    public static class RequestLimit {
        /**
         * 同一IP1分钟内请求同一接口的最大次数
         */
        private int oneMinuteMaxCount;
        /**
         * 同一IP1天内请求同一接口的最大次数
         */
        private int oneDayMaxCount;
    }
}
