package com.gooluke.biz.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author 咕噜科
 * ClassName: ThreadConfiguration
 * date: 2023-10-22 3:28
 * Description:
 * version 1.0
 */
@Configuration
public class ThreadConfiguration {

    @Bean("threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolExecutor(@Value("${threadPool.corePoolSize}") int corePoolSize,
                                                     @Value("${threadPool.maxPoolSize}") int maxPoolSize,
                                                     @Value("${threadPool.keepAliveSeconds}") int keepAliveSeconds,
                                                     @Value("${threadPool.queueCapacity}") int queueCapacity,
                                                     @Value("${threadPool.threadNamePrefix}") String threadNamePrefix
    ) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }

}
