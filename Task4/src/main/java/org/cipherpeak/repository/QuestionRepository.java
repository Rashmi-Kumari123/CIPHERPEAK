package org.cipherpeak.repository;

import org.cipherpeak.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAllQuestions();
}
