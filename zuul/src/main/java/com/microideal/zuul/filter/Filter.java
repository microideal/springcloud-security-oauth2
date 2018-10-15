package com.microideal.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * author microideal on 2018/5/19
 */
@Component
public class Filter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0; //定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return false; //表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() {
        return null; //filter需要执行的具体操作
    }
}
