package com.example.coursovayarabota2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.Collection;

@Controller
@RequestMapping(path = "/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    public Collection <Question> getQuestions (int amount){
        return examinerService.qetQuestion(amount);
    }
}
