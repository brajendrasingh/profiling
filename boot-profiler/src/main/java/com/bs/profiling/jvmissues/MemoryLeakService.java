package com.bs.profiling.jvmissues;

import com.bs.profiling.dto.Employee;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryLeakService {
    // Static collection/reference: remains reachable for the lifetime of the class and typically the application.
    private static final List<byte[]> staticCollection = new ArrayList<>();//For Memory leak
    private static final ThreadLocal<byte[]> THREAD_LOCAL = new ThreadLocal<>();

    public MemoryLeakService() {
    }

    public void createMemoryLeaksByStaticCollections() {
        System.out.println("Objects retained by memoryLeakList: " + staticCollection.size());
        staticCollection.add(new byte[1024 * 1024]); //For creating memory leak: list is static & keeps growing.
    }

    public void createMemoryLeaksByUnboundedCache() {
        Map<Long, Employee> cache = new HashMap<>();
        cache.put(1L, new Employee());
        System.out.println("Objects retained by cache: " + cache.size());
    }

    public void createMemoryLeaksByThreadLocal() {
        THREAD_LOCAL.set(new byte[10 * 1024 * 1024]);
    }

    //Like files or db connections
    public void createMemoryLeaksByUnclosedResources() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("data.txt");
    }
}
