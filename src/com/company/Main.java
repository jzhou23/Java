package com.company;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // set up how many rounds
        Test test = new Test(10);
        System.out.println("Start your test");

        while (test.hasNextQuestion()) {
            Question nextQuestion = test.getNextQuestion();
            long prev = Calendar.getInstance().getTimeInMillis();
            int temp = -1;
            do {
                System.out.println(nextQuestion.getA() + "+" + nextQuestion.getB() + "=?");
                String input = scanner.nextLine();

                // enter "quit" to quit the test
                if (input.equals("quit")) {
                    System.out.println("Thank you for your time!");
                    return;
                }
                temp = Integer.parseInt(input);
            } while (temp != nextQuestion.getAnswer());

            long now = Calendar.getInstance().getTimeInMillis();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(now - prev);

            test.setQuestionSeconds(nextQuestion, seconds);
            test.addSeconds(seconds);
        }

        System.out.println("Congratulation, you finished all the questions!\n");
        System.out.println("Total cost: " + test.getTotalSeconds() + "s");
        List<Question> questionList = test.getTop5Questions();
        System.out.println("top 5 questions:");
        int i = 0;
        for (Question question : questionList) {
            System.out.println(i + 1 + ". " + question.getA() + "+" + question.getB() + "=?");
            System.out.println("seconds cost: " + question.getTime() + "s");
            i++;
        }
    }
}


