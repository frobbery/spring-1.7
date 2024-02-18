package com.example.spring_17.service.question;

import java.util.Locale;

public interface QuestionService {

    void printAllQuestionsWithAnswers(Locale locale);

    Boolean conductTesting(Locale locale);
}
