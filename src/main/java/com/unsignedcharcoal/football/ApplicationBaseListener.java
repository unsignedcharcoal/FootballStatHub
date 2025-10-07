package com.unsignedcharcoal.football;

import com.unsignedcharcoal.football.cache.CacheConnection;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.event.ApplicationShutdownEvent;
import io.micronaut.runtime.event.ApplicationStartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationBaseListener {

    @Singleton
    public static final class StartupApplication implements ApplicationEventListener<ApplicationStartupEvent>{

        @Override
        public void onApplicationEvent(ApplicationStartupEvent event) {
            log.info("Running Application");
        }
    }

    @Singleton
    public static final class ShutdownApplication implements ApplicationEventListener<ApplicationShutdownEvent>{

        @Inject
        CacheConnection cacheConnection;

        @Override
        public void onApplicationEvent(ApplicationShutdownEvent event) {
            log.info("Shutting down Application");
            cacheConnection.client().shutdown();
        }
    }

}
