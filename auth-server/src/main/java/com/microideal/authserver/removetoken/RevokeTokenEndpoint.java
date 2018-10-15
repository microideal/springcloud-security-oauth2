package com.microideal.authserver.removetoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author microideal on 2018/7/26
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    /**
     * 请求时带上httpBasic认证，即client和secret
     * @param access_token
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public ResponseEntity<String> revokeToken(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)){
            return new ResponseEntity<>("注销成功", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("注销失败", HttpStatus.OK);
        }
    }
}
