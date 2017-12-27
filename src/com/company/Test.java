package com.company;

import java.util.*;

public class Test {
    private int rounds;
    private PriorityQueue<Question> questionQueue;
    private boolean[] map;
    private Random random;
    private long totalSeconds;

    public Test(int rounds) {
        this.rounds = rounds;
        random = new Random();
        map = new boolean[100];

        questionQueue = new PriorityQueue<>(new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o1.getTime() < o2.getTime() ? 1 : -1;
            }
        });
    }

    public Question getNextQuestion() {
        int a = -1;
        int b = -1;
        int sum = -1;
        do {
            a = random.nextInt(9) + 1;
            b = random.nextInt(9) + 1;
            sum = a * 10 + b;
        } while (sum == -1 || map[sum]);
        map[a * 10 + b] = true;
        map[b * 10 + a] = true;

        Question newQuestion = new Question(a, b);
        rounds--;
        return newQuestion;
    }

    public boolean hasNextQuestion() {
        return rounds > 0;
    }

    public List<Question> getTop5Questions() {
        List<Question> res = new ArrayList<>();
        while (questionQueue != null && res.size() < 5) {
            Question question = questionQueue.poll();
            res.add(question);
        }
        return res;
    }

    public void addSeconds(long seconds) {
        totalSeconds += seconds;
    }

    public long getTotalSeconds() {
        return this.totalSeconds;
    }

    public void setQuestionSeconds(Question question, long seconds) {
        question.setTime(seconds);
        questionQueue.offer(question);
    }
}
