package com.bs.profiling.jvmissues;

import org.springframework.stereotype.Component;

@Component
public class ThreadProblemService {

    public ThreadProblemService() {
    }

    public String threadBlockage() throws InterruptedException {
        System.out.println("Request started: " + Thread.currentThread().getName());
        Thread.sleep(120_000);//2 Minutes
        return "Request completed";
    }

    public String threadDeadlock() throws InterruptedException {
        return "success";
    }

    public String threadStarvation() throws InterruptedException {
        return "success";
    }

    public String tooManyThreads() throws InterruptedException {
        return "success";
    }
}
