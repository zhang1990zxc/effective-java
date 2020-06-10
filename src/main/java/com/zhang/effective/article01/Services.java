package com.zhang.effective.article01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhang
 * @Description 考虑用静态工厂代替构造器
 * @Date 2020-01-17 15:38
 * @Version 1.0
 **/
public class Services {

    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider provider){
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    public static void registerProvider(String name, Provider provider) {
        providers.put(name, provider);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider provider = providers.get(name);
        if(provider==null)
            throw new IllegalArgumentException("No provider registered with name: "+name);
        return provider.newService();
    }

}
