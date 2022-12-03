package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;
import cn.xusc.trace.core.util.TraceRecorders;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 信息隐藏应用引导启动器
 *
 * <p>
 * 启用记录所有：
 * traceRecorder.recordAll();
 * </p>
 *
 * @author wangcai
 */
public class MessageHideApplyBootstrap {
    
    public static void main(String[] args) throws ScriptException {
        TraceRecorder traceRecorder = new TraceRecorder();
//        traceRecorder.recordAll();
        double value = Calculator.PLUS.calculation(2, 2);
        traceRecorder.log("value: {}", value);
    }
    
    /**
     * 计算器
     */
    private enum Calculator {
        /**
         * 加
         */
        PLUS("+"),
        /**
         * 减
         */
        SUBTRACT("-"),
        /**
         * 乘
         */
        MULTIPLY("*"),
        /**
         * 除
         */
        DIVIDE("/");
        
        /**
         * 符号
         */
        private final String symbol;
        
        Calculator(String symbol) {
            this.symbol = symbol;
        }
        
        /**
         * 计算
         *
         * @param a 第一个参数
         * @param b 第二个参数
         * @return 两个参数的计算结果
         * @throws ScriptException 如果脚本中出现错误。ScriptEngines应该为底层脚本实现抛出的检查异常创建和抛出ScriptException包装器。
         */
        public double calculation(double a, double b) throws ScriptException {
            String expression = a + symbol + b;
            TraceRecorders.get().log("expression: {}=?", expression, false);
            
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            TraceRecorders.get().log("get [ nashorn ] script engine", false);
            
            return (double) engine.eval(expression);
        }
    }
}
