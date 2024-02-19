package com.example.spring_17.dao;


import com.example.spring_17.TestConfiguration;
import com.example.spring_17.config.QuestionConfig;
import com.example.spring_17.domain.QuestionWithAnswers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@DisplayName("Класс QuestionDaoImpl")
@SpringBootTest(classes = TestConfiguration.class)
class QuestionDaoImplTest {

    @Autowired
    private QuestionConfig questionConfig;

    private QuestionDaoImpl sut;

    @BeforeEach
    void setSut() {
        sut = new QuestionDaoImpl(questionConfig);
    }

    @Test
    @DisplayName("Должен добавлять вопросы")
    void shouldAddQuestion() {
        //given
        var question = mock(QuestionWithAnswers.class);

        //when
        sut.addQuestion(question);

        //then
        assertEquals(sut.getAllQuestions().size(), 1);
    }

    @Test
    @DisplayName("Должен выдавать все вопросы")
    void shouldGetAllQuestions() {
        //given
        var question = mock(QuestionWithAnswers.class);
        sut.addQuestion(question);

        //when
        var result = sut.getAllQuestions();

        //then
        Assertions.assertThat(result)
                .contains(question)
                .hasSize(1);
    }

    @Test
    @DisplayName("Должен добавлять вопросы из файла")
    void shouldAddQuestionsFromFile() throws IOException, URISyntaxException {
        //when
        sut.addQuestionsFromFile();

        //then
        assertEquals(sut.getAllQuestions().size(), 2);
    }
}