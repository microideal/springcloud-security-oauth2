package com.microideal.zuul.fallback;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class Fallback implements FallbackProvider {
    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);

    @Override
    public String getRoute() {
        return "*";//api服务id，如果需要所有调用都支持回退，则return "*"或return null
    }

    /**
     * 如果请求用户服务失败，返回什么信息给消费者客户端
     */
    @Override
    public ClientHttpResponse fallbackResponse(String routing,Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return 200;
            }

            @Override
            public String getStatusText() {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                if (cause != null && cause.getCause() != null) {
                    String reason = cause.getCause().getMessage();
                    logger.info("log -> Exception: {}",reason);
                    logger.info("log -> routing: {}",routing);
                }

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "9999");
                jsonObject.put("msg", "服务故障，请稍后重试!");
                jsonObject.put("routing", routing);
                return new ByteArrayInputStream(jsonObject.toJSONString().getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
