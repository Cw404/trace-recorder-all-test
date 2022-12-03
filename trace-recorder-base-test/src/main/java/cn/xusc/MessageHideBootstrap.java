package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;

/**
 * 信息隐藏引导启动器
 *
 * @author wangcai
 */
public class MessageHideBootstrap {
    
    public static void main(String[] args) {
        new TraceRecorder().log("hello {}!", "TraceRecorder");
        new TraceRecorder().log("hello {}! but is hide", "TraceRecorder", false);
    }
}
