package org.cipherpeak;

import org.cipherpeak.repository.*;
import org.cipherpeak.repository.QuestionRepository;
import org.cipherpeak.service.QuizService;

public class QuizApp {
    public static void main(String[] args) {
        QuestionRepository repo = new InMemoryQuestionRepository();
        QuizService quizService = new QuizService(repo);
        quizService.startQuiz();
    }
}
