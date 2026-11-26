package com.bs.profiling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Prerequisites: Enable Core Dump generation at the OS level: ulimit -c unlimited
 * Categories:
 * Native library/JNI crash: like using c lang code
 * JVM internal fatal error
 * kill -6 PID on Linux
 * gcore PID: It doesn't terminate JVM
 */
@RestController
@RequestMapping("/coreDump")
public class CoreDumpController {

    @GetMapping("/memory")
    public String memory() {
        throw new OutOfMemoryError("Simulated Java OOM");
    }

    @GetMapping("/crash")
    public String crash() {
        Runtime.getRuntime().halt(134);
        return "Never executed";
    }

    //JVM internal fatal error category
    @GetMapping("/trigger-fatal-error")
    public String triggerFatalError() {
        byte[] memory = new byte[1024 * 1024 * 1024];
        return "Allocated memory: " + memory.length;
    }

    //kill -6 PID on Linux category
    @GetMapping("/trigger-core-dump")
    public String triggerCoreDump() throws Exception {
        long pid = ProcessHandle.current().pid();
        new ProcessBuilder("kill", "-6", String.valueOf(pid)).start();
        return "Core dump triggered";
    }
}