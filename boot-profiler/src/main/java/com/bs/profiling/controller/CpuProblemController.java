package com.bs.profiling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CpuProblemController {

    private volatile long counter;

    @GetMapping("/loop")
    public String highCpuDueToInfiniteLoops() {
        long endTime = System.currentTimeMillis() + 60_000; // 60 seconds
        while (System.currentTimeMillis() < endTime) {
            counter++;
        }
        return "CPU load generated for 10 seconds. Counter: " + counter;
    }

    @GetMapping("/tomanythread")
    public String highCpuDueToMultipleConcurrentThreads() {

        return "Success";
    }

    @GetMapping("/processing")
    public String highCpuDueToProcessing() {
        //CPU-intensive processing
        return "Success";
    }
}
