package com.example.spring_17.shell;


import com.example.spring_17.service.question.QuestionService;
import com.example.spring_17.shell.aspect.CatchAndWrite;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Locale;

@RequiredArgsConstructor
@ShellComponent
public class ShellCommands {

    private final QuestionService questionService;

    @ShellMethod("conductTesting")
    @CatchAndWrite
    public void conductTesting(@ShellOption(defaultValue = "ru_ru") String localeName) {
        questionService.conductTesting(new Locale(localeName));
    }

    @ShellMethod("printQuestions")
    @CatchAndWrite
    public void printQuestions(@ShellOption(defaultValue = "ru_ru") String localeName) {
        questionService.printAllQuestionsWithAnswers(new Locale(localeName));
    }
}
