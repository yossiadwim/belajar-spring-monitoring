package com.example.belajar_spring_monitoring;


import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class MyScheduleTask {

    @Autowired
    private MeterRegistry meterRegistry;

    @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
    void build(){
        meterRegistry.counter("my.counter").increment();
        log.info("Hello");
    }
}
