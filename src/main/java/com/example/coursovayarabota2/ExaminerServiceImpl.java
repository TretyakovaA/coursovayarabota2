package com.example.coursovayarabota2;

import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> qetQuestion(int amount) {
        Set <Question> questions = new HashSet<>();
        if (questionService.getAll().size()<= amount && amount >0)
        throw new BadRequest();
        while (questions.size()<amount)
        questions.add(questionService.getRandomQuestion());
        return questions;
    }

}
