package com.phd.quesans.service;

import java.util.List;

import com.phd.quesans.dto.QuestionDTO;
import com.phd.quesans.dto.SearchEngineDTO;
import com.phd.quesans.dto.SearchKeywordDTO;
import com.phd.quesans.model.Question;

public interface QuesAnsService {
	public List<String> listQuestion(String term);
	public QuestionDTO getQuestionPojo(String question);
	public List<SearchEngineDTO> listSearchEngine();
	public List<SearchKeywordDTO> listKeyword(int quesid);
	
}
