package com.example.spring_17.dao;



import com.example.spring_17.domain.QuestionWithAnswers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface QuestionDao {

    void addQuestion(QuestionWithAnswers question);

    List<QuestionWithAnswers> getAllQuestions();

    void addQuestionsFromFile() throws IOException, URISyntaxException;
}
