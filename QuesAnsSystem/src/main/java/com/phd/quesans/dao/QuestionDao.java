package com.phd.quesans.dao;

import java.util.List;

import com.phd.quesans.dto.QuestionDTO;
import com.phd.quesans.dto.SearchEngineDTO;
import com.phd.quesans.dto.SearchKeywordDTO;


public interface QuestionDao {
	public List<String> listQuestion(String term);
	public QuestionDTO getQuestionPojo(String question);
	public List<SearchEngineDTO> listSearchEngine();
	public List<SearchKeywordDTO> listKeyword(int quesid);
	
}
