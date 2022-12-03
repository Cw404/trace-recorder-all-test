package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;
import cn.xusc.trace.core.util.TraceRecorders;

/**
 * 本地（局部）共享引导启动器
 *
 * @author wangcai
 */
public class LocalSharedBootstrap {
    
    public static void main(String[] args) {
        TraceRecorder recorder = new TraceRecorder();
        firstMethod();
        secondMethod();
    }
    
    public static void firstMethod() {
        TraceRecorders.get().log("this is first method!");
    }
    
    public static void secondMethod() {
        TraceRecorders.get().log("this is second method!");
    }
}
