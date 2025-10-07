package org.cipherpeak.service;

import org.cipherpeak.model.Question;
import org.cipherpeak.repository.QuestionRepository;

import java.util.*;
import java.util.concurrent.*;

public class QuizService {
    private final List<Question> questions;
    private int score = 0;
    private final Scanner scanner = new Scanner(System.in);
    private final int timePerQuestion = 10; // seconds

    public QuizService(QuestionRepository repository) {
        this.questions = repository.getAllQuestions();
    }

    public void startQuiz() {
        System.out.println("🧠 Welcome to the Quiz! You have " + timePerQuestion + " seconds per question.");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < questions.size(); i++) {
            askQuestion(questions.get(i), i + 1);
        }

        System.out.println("\n✅ Quiz Completed!");
        System.out.println("Your Final Score: " + score + "/" + questions.size());
    }

    private void askQuestion(Question question, int qNumber) {
        System.out.println("\nQuestion " + qNumber + ": " + question.getQuestionText());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.println("\n(⏳ You have " + timePerQuestion + " seconds to answer)");
        System.out.print("Your answer (1-4): ");
        System.out.flush();

        String userInput = readLineWithTimeout(timePerQuestion);

        if (userInput == null || userInput.isEmpty()) {
            System.out.println("\n⏰ Time's up or no input! Moving to next question...");
            System.out.println("❌ No answer given.");
            return;
        }

        checkAnswer(userInput.trim(), question);
    }

    private String readLineWithTimeout(int timeoutSeconds) {
        ExecutorService single = Executors.newSingleThreadExecutor();
        Callable<String> readTask = () -> {
            try {
                if (scanner.hasNextLine()) return scanner.nextLine();
                else return "";
            } catch (NoSuchElementException e) {
                return "";
            }
        };

        Future<String> future = single.submit(readTask);
        try {
            // Wait for user input within timeoutSeconds
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (TimeoutException te) {
            future.cancel(true); // attempt to cancel the blocked read-thread
            return null; // signal timeout
        } catch (InterruptedException | ExecutionException e) {
            return null;
        } finally {
            // shutdown the executor; the blocked read thread may be interrupted or left, but this is acceptable for small runs
            single.shutdownNow();
        }
    }

    private void checkAnswer(String input, Question question) {
        List<String> options = question.getOptions();
        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.size()) {
                String selected = options.get(choice - 1);
                if (selected.equalsIgnoreCase(question.getCorrectAnswer())) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Incorrect! Correct Answer: " + question.getCorrectAnswer());
                }
            } else {
                System.out.println("⚠️ Invalid choice! Enter 1-" + options.size() + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Please enter a valid number (1-" + options.size() + ").");
        }
    }
}