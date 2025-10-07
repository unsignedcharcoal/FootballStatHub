package com.unsignedcharcoal.football.cache;

import io.lettuce.core.RedisClient;
import jakarta.inject.Singleton;

@Singleton
public class CacheConnection {

    public RedisClient client(){
        return RedisClient.create("redis://localhost:6379");
    }

}
