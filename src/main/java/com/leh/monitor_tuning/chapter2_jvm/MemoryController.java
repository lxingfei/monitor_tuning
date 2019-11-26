package com.leh.monitor_tuning.chapter2_jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: leh
 * @Date: 2019/11/21 14:32
 * @Description:
 */
@RestController
public class MemoryController {

    private List<User> userList = new ArrayList<>();

    private List<Class<?>> classList = new ArrayList<>();

    /**
     * 模拟堆内存溢出
     * 只要MemoryController不被回收，List就不会被回收
     * -Xmx32M -Xms32M
     * output:
     * Exception in thread "http-nio-9900-exec-1" java.lang.OutOfMemoryError: GC overhead limit exceeded
     * @return
     */
    @GetMapping("/heap")
    public String heap() {
        int i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    /**
     * 模拟非堆内存溢出 - 即MetaSpace溢出
     * 只要MemoryController不被回收，classList不会被回收，那么其存储的Class不会被回收
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * @return
     * output:
     * Exception in thread "http-nio-9900-exec-1" java.lang.OutOfMemoryError: Metaspace
     */
    @GetMapping("/noheap")
    public String noheap() {
        while (true) {
            //如何动态生成class文件，常用的是 asm
            classList.addAll(Metaspace.createClasses());
        }
    }
}
