package com.microideal.orderserver.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author microideal on 2018/7/12
 */
@Component
@ConfigurationProperties
@Data
public class Districts {
    private List<District> districts;
}
