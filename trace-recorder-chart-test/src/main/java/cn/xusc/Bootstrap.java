package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;

/**
 * 引导启动器
 *
 * <p>
 * 入门使用
 * </p>
 *
 * @author wangcai
 */
public class Bootstrap {
    public static void main(String[] args) {
        new TraceRecorder().log("hello TraceRecorder!");
    }
}