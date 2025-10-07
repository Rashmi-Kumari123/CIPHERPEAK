package org.cipherpeak.repository;

import org.cipherpeak.model.Question;

import java.util.*;

public class InMemoryQuestionRepository implements QuestionRepository {

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "What is the capital of France?",
                Arrays.asList("Paris", "London", "Berlin", "Madrid"),
                "Paris"
        ));
        questions.add(new Question(
                "Which programming language is platform-independent?",
                Arrays.asList("C", "C++", "Java", "Python"),
                "Java"
        ));
        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                Arrays.asList("Earth", "Mars", "Venus", "Jupiter"),
                "Mars"
        ));
        questions.add(new Question(
                "What is 2 + 2 * 2?",
                Arrays.asList("6", "8", "4", "10"),
                "6"
        ));

        return questions;
    }
}
