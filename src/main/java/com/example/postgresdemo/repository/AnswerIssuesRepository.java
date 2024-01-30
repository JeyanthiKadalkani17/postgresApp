package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Answer;
import com.example.postgresdemo.model.Answer_Issues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerIssuesRepository extends JpaRepository<Answer_Issues, Long> {
    List<Answer> findByQuestionId(Long questionId);
}
