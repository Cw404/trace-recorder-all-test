package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;
import cn.xusc.trace.core.util.TraceRecorders;

/**
 * 一天的生活引导启动器
 *
 * <p>
 * 简约描述一天的生活状况
 * </p>
 *
 * @author wangcai
 */
public class OneDayLifeBootstrap {
    
    public static void main(String[] args) {
        new TraceRecorder();
        new Morning().doSomething();
        new Noon().doSomething();
        new Afternoon().doSomething();
        new Night().doSomething();
    }
    
    /**
     * 时刻
     */
    public interface Moment {
        
        /**
         * 做某事
         */
        void doSomething();
    }
    
    /**
     * 早上
     */
    public static class Morning implements Moment {
        
        @Override
        public void doSomething() {
            TraceRecorders.get().log("open my eyes~");
            TraceRecorders.get().log("eat breakfast");
            TraceRecorders.get().log("brush short video");
        }
    }
    
    /**
     * 中午
     */
    public static class Noon implements Moment {
        
        @Override
        public void doSomething() {
            TraceRecorders.get().log("eat lunch");
            TraceRecorders.get().log("sleep");
        }
    }
    
    /**
     * 下午
     */
    public static class Afternoon implements Moment {
        
        @Override
        public void doSomething() {
            TraceRecorders.get().log("play games");
        }
    }
    
    /**
     * 晚上
     */
    public static class Night implements Moment {
        
        @Override
        public void doSomething() {
            TraceRecorders.get().log("eat dinner");
            TraceRecorders.get().log("go to sleep, with say good night to world!");
        }
    }
}