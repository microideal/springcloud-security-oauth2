package com.microideal.orderserver.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author microideal on 2018/7/12
 */
@Component
@ConfigurationProperties(prefix = "system-employee")
@Data
public class SystemEmployee {  //spring的bean是单例的（加载进来修改后就不变了）
    private Long id;
    private String username;
    private String district;
}
