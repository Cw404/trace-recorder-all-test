package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;

/**
 * 多方法引导启动器
 *
 * @author wangcai
 */
public class MultipleMethodsBootstrap {
    
    
    public static void main(String[] args) {
        TraceRecorder recorder = new TraceRecorder();
        // - 案例一
//        new CaseOne().firstMethod(recorder).secondMethod(recorder);
        
        // - 案例二
        new CaseTwo(recorder).firstMethod().secondMethod();
    }
    
    
    /**
     * 案例一
     */
    public static class CaseOne {
        
        public CaseOne firstMethod(TraceRecorder recorder) {
            recorder.log("this is first method!");
            return this;
        }
        
        public CaseOne secondMethod(TraceRecorder recorder) {
            recorder.log("this is second method!");
            return this;
        }
    }
    
    /**
     * 案例二
     */
    public static class CaseTwo {
        TraceRecorder recorder;
        
        public CaseTwo(TraceRecorder recorder) {
            this.recorder = recorder;
        }
        
        public CaseTwo firstMethod() {
            recorder.log("this is first method!");
            return this;
        }
        
        public CaseTwo secondMethod() {
            recorder.log("this is second method!");
            return this;
        }
    }
}
