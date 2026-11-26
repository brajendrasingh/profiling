package com.bs.profiling.controller;

import com.bs.profiling.jvmissues.MemoryLeakService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memory")
public class MemoryLeakController {

    private MemoryLeakService memoryLeakService;

    public MemoryLeakController(MemoryLeakService memoryLeakService) {
        this.memoryLeakService = memoryLeakService;
    }

    @GetMapping("/leak")
    public String createLeak() {
        memoryLeakService.createMemoryLeaksByStaticCollections();
        return "success";
    }
}
