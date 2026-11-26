package com.bs.profiling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CpuProblemController {

    @GetMapping("/loop")
    public String highCpuDueToInfiniteLoops() {

        return "Success";
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
