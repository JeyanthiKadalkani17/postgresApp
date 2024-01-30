package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.repository.AnswerIssuesRepository;
import com.example.postgresdemo.repository.QuestionRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AnswerIssueController {

    @Autowired
    private AnswerIssuesRepository answerIssuesRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    Gson gson;

    @GetMapping("/getAllQuestions")
    public String getAllQuestion() {
        logger.error("No Such Customer exists!! throws 500 Internal Server issues!!!");
        throw new NoSuchElementException(
                "No Such Customer exists!!");
    }

    @GetMapping("/getFullDetails")
    public String getFullDetails() {
        for(int i=1;i<5;i++){
            // the thread will sleep for the 500 milli seconds
            try{Thread.sleep(1000);}
            catch(InterruptedException e)
            {System.out.println(e);}

            System.out.println(i);

        }
        logger.info("Endpoint taking more time");
        return  "Endpoint taking more time";

    }

    @GetMapping("/questions/{questionId}/answerIssues")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionId) throws Exception {
        logger.info("Entered into /questions endpoint");
        List<Answer> answer=new ArrayList<>();
        try {
            answer = answerIssuesRepository.findByQuestionId(questionId);
            gson = new Gson();
            String jsonInString = gson.toJson(answer);
            logger.info(jsonInString);

        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            throw e;

        }
        return answer;
    }

}
