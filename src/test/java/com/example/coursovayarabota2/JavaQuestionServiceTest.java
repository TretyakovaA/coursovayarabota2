package com.example.coursovayarabota2;

import com.example.coursovayarabota2.Question;
import com.example.coursovayarabota2.JavaQuestionService;
import com.example.coursovayarabota2.QuestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class JavaQuestionServiceTest {


    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void afterEach() {
        Collection<Question> questions = questionService.getAll();
        questions.forEach(questionService::remove);
    }

    @Test
    public void removeTest() {
        assertThat(questionService.getAll().isEmpty());
        Question expected = addOneQuestion();
        questionService.remove(expected);
        assertThat(questionService.getAll().isEmpty());

    }

    @Test
    public void CheckAddQuestion() {
        questionService.add("Q", "A");
        assertThat(questionService.getAll()).hasSize(1);
    }

    @Test
    public void getRandomQuestionTest() {
        assertThat(questionService.getAll()).isEmpty();
        int size = 5;
        for (int i = 0; i < size; i++) {
            addOneQuestion("Q" + 1, "A" + 1);
        }
        assertThat(questionService.getAll()).hasSize(size);
        assertThat(questionService.getRandomQuestion());
    }

    private Question addOneQuestion(String question, String answer) {
        int size = questionService.getAll().size();
        questionService.add(question, answer);
        assertThat(questionService.getAll()).hasSize(size + 1);
        Question expected = new Question("Q", "A");
        assertThat(questionService.getAll()).contains(expected);
        return expected;
    }

    private Question addOneQuestion() {
        Question expected = new Question("Q", "A");
        questionService.add("Q", "A");
        assertThat(questionService.getAll()).hasSize(1);
        assertThat(questionService.getAll()).contains(expected);
        return expected;
    }
}
