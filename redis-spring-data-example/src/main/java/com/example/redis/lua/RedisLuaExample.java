package com.example.redis.lua;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Controller
public class RedisLuaExample {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping
    public void start() {
        init();
    }

    @SneakyThrows
    public void init() {
        Resource resource = new ClassPathResource("accountSum.lua");
        InputStream inputStream = resource.getInputStream();
        String luaScriptString = new String(FileCopyUtils.copyToByteArray(inputStream), StandardCharsets.UTF_8);
        List<String> keys = Collections.singletonList("customer001");
        String[] args = new String[] {"savingAcc", "fdAcc", "currentAcc"};
        String result = redisTemplate.execute(convertStringToScript(luaScriptString), keys, "savingAcc", "fdAcc", "currentAcc");
        System.out.println("Total Amount : " + result);
    }

    private static RedisScript<String> convertStringToScript(String script) {
        Resource scriptSource = new ClassPathResource(script);
        return RedisScript.of(scriptSource, String.class);
    }
}
