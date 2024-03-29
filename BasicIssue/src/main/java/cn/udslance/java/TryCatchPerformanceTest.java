package cn.udslance.java;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * try - catch 性能测试
 * @author H
 */
@BenchmarkMode(Mode.AverageTime) // 测试完成时间
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS) // 预热 1 轮，每次 1s
@Measurement(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS) // 测试 5 轮，每次 3s
@Fork(1) // fork 1 个线程
@State(Scope.Benchmark)
@Threads(100)
public class TryCatchPerformanceTest {
    // 循环次数
    private static final int forSize = 1000;

    public static void main(String[] args) throws RunnerException {
        // 启动基准测试
        Options opt = new OptionsBuilder()
                .include(TryCatchPerformanceTest.class.getSimpleName()) // 要导入的测试类
                // 输出测试结果的文件
                .output("/Users/H/Documents/Codes/TryCatchPerformanceTest.log")
                .build();
        new Runner(opt).run(); // 执行测试
    }

    @Benchmark
    public int innerForeach() {
        int count = 0;
        for (int i = 0; i < forSize; i++) {
            try {
                if (i == forSize) {
                    throw new Exception("new Exception");
                }
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Benchmark
    public int outerForeach() {
        int count = 0;
        try {
            for (int i = 0; i < forSize; i++) {
                if (i == forSize) {
                    throw new Exception("new Exception");
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
