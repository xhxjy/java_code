package test;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Excise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("请输入成绩：");
            double score = scanner.nextDouble();  // 捕获非数字输入异常
            validateScore(score);  // 自定义校验逻辑
            System.out.println("有效成绩：" + score);
        } catch (InputMismatchException e) {
            System.out.println("输入类型错误，请确保输入数字");
        } catch (ScoreException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
            System.out.println("程序结束");  // 参考搜索结果[2][6]
        }
    }

    // 成绩校验方法（参考搜索结果[4][8]）
    private static void validateScore(double score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("成绩需在0-100之间");
        }
    }
}
// 继承Exception实现受检异常
class ScoreException extends Exception {
    private String message;  // 异常描述

    public ScoreException(String message) {
        super(message);
        this.message = message;
    }

    // 获取异常信息（参考搜索结果[2][7]）
    @Override
    public String getMessage() {
        return "成绩异常：" + message;
    }
}
