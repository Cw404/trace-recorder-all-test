package cn.xusc;

import cn.xusc.trace.core.TraceRecorder;
import cn.xusc.trace.core.util.TraceRecorders;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Objects;
import java.util.Scanner;

/**
 * 计算器引导启动器
 *
 * <p>
 * 计算器的使用
 * </p>
 *
 * @author wangcai
 */
public class CalculatorBootstrap {
    
    public static void main(String[] args) throws ScriptException {
        TraceRecorder recorder = new TraceRecorder();
        recorder.recordAll();
        
        Double a = null;
        double b;
        Calculator calculator;
        recorder.log("得到系统的扫描仪");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (Objects.isNull(a)) {
                System.out.print("请输入第一个数：");
                a = scanner.nextDouble();
                recorder.log("获取输入的第一个小数：{}", a);
            }
            System.out.print("请输入计算器符号：");
            String symbol = scanner.next();
            recorder.log("获取计算器符号: {}", symbol);
            recorder.log("查找对应符号的计算器", false);
            calculator = Calculator.find(symbol);
            System.out.print("请输入第二个数：");
            b = scanner.nextDouble();
            recorder.log("获取输入的第二个小数: {}", b);
            recorder.log("开始计算a{}b=?", symbol);
            a = calculator.calculation(a, b);
            recorder.log("得到结果[ {} ], 重新赋值给a", a, false);
            System.out.print("是否继续计算（true/false）：");
            if (!scanner.nextBoolean()) {
                recorder.log("不需要计算了");
                break;
            }
        }
        recorder.log("value: {}", a);
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
         * 查找计算器
         *
         * @param symbol 符号
         * @return 计算器
         */
        public static Calculator find(String symbol) {
            TraceRecorders.get().log("开始查找对应符号[ {} ]计算器", symbol, false);
            for (Calculator calculator : values()) {
                if (Objects.equals(calculator.symbol, symbol)) {
                    return calculator;
                }
            }
            TraceRecorders.get().log("没找到符号[ {} ]的计算器", symbol, false);
            throw new IllegalArgumentException("illegal symbol: " + symbol);
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
            TraceRecorders.get().log("得到表达式: {}", expression, false);
            
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            TraceRecorders.get().log("获取脚本引擎: {}", "nashorn", false);
            
            double value = (double) engine.eval(expression);
            TraceRecorders.get().log("计算表达式: {} = {}", expression, value);
            return value;
        }
    }
}
