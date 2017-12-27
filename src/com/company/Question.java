package com.company;

public class Question {
    private int a;
    private int b;
    private int answer;
    private long time;

    public Question(int a, int b) {
        this.a = a;
        this.b = b;
        this.answer = a + b;
        time = 0;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getAnswer() {
        return answer;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
