package com.example.coursovayarabota2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions;
    private final int size = 5;
    private Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>(size);
        this.random = new Random();
    }

    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    public Collection<Question> getAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }


}
