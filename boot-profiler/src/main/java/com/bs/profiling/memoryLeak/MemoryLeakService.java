package com.bs.profiling.memoryLeak;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryLeakService {
    // Static collection: remains reachable for the lifetime of the class and typically the application.
    private static final List<byte[]> memoryLeakList = new ArrayList<>();//For Memory leak

    public MemoryLeakService() {
    }

    public void createMemoryLeak() {
        System.out.println("Objects retained by memoryLeakList: " + memoryLeakList.size());
        memoryLeakList.add(new byte[1024 * 1024]); //For creating memory leak: list is static & keeps growing.
    }
}
