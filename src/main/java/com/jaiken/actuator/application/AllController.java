package com.jaiken.actuator.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Slf4j
@RestController
@RequestMapping("/")
public class AllController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/")
    public String index() {
        String result = redisTemplate.opsForValue().get("1");
        redisTemplate.opsForValue().set("1", String.valueOf(System.currentTimeMillis()));
        log.warn(result);
        return result;
    }
}
