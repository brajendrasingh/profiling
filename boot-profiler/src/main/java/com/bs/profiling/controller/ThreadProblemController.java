package com.bs.profiling.controller;

import com.bs.profiling.jvmissues.ThreadProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadProblemController {

    private ThreadProblemService threadProblemService;

    public ThreadProblemController(ThreadProblemService threadProblemService) {
        this.threadProblemService = threadProblemService;
    }

    @GetMapping("/block")
    public String blockThread() throws InterruptedException {
        return threadProblemService.threadBlockage();
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running";
    }
}
