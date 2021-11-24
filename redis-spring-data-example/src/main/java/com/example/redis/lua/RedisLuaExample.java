package com.example.redis.lua;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
public class RedisLuaExample {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @SneakyThrows
    @PostConstruct
    public void init() {
        List<String> keys = Collections.singletonList("customer001");
        String[] args = new String[] {"savingAcc", "fdAcc", "currentAcc"};
        Long result = redisTemplate.execute(getScript(), keys, args);
        System.out.println("Total Amount : " + result.toString());
    }

    private static RedisScript<Long> getScript() {
        Resource scriptSource = new ClassPathResource("account_sum.lua");
        return RedisScript.of(scriptSource, Long.class);
    }
}
