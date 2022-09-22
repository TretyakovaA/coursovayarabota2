package com.example.coursovayarabota2;
import com.example.coursovayarabota2.Question;
import com.example.coursovayarabota2.ExaminerServiceImpl;
import com.example.coursovayarabota2.JavaQuestionService;
import com.example.coursovayarabota2.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        Collection<Question> questions = Stream.of(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3"),
                new Question("Q4", "A4"),
                new Question("Q5", "A5")
        ).collect(Collectors.toSet());

        when(javaQuestionService.getAll()).thenReturn(questions);

    }

    @Test
    public void getQuestionTest() {
        List<Question> questions = new ArrayList<>(javaQuestionService.getAll());
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0)

        );

        assertThat(examinerService.qetQuestion(3)).containsExactly(questions.get(0));
    }
}
