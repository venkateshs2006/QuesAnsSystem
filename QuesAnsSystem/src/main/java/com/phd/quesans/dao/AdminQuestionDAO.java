package com.phd.quesans.dao;

import java.util.List;

import com.phd.quesans.dto.QuestionDTO;

public interface AdminQuestionDAO {
	public QuestionDTO getQuestion(int id);
	public List<QuestionDTO> getQuestionList();
	public int addQuestion(QuestionDTO question);
	public int deleteQuestion(QuestionDTO question);
}
