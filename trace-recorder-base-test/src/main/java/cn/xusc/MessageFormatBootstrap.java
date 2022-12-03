package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;

/**
 * 信息格式化引导启动器
 *
 * @author wangcai
 */
public class MessageFormatBootstrap {
    
    public static void main(String[] args) {
        new TraceRecorder().log("hello {}!", "TraceRecorder");
    }
}
