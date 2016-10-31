package com.phd.quesans.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.dao.QuestionDao;
import com.phd.quesans.dto.QuestionDTO;
import com.phd.quesans.dto.SearchEngineDTO;
import com.phd.quesans.dto.SearchKeywordDTO;
import com.phd.quesans.service.QuesAnsService;
@Service
public class QuesAnsServiceImpl implements QuesAnsService {
	 @Autowired
	 private QuestionDao questionDao;
	@Transactional
    public List<String> listQuestion(String term) {
		List<String> listQuestions=new ArrayList<String>();
		listQuestions=questionDao.listQuestion(term);
		return listQuestions;
    }
	@Transactional
	public QuestionDTO getQuestionPojo(String question) {
		return questionDao.getQuestionPojo(question);
	}
	@Transactional
	public List<SearchEngineDTO> listSearchEngine() {
		// TODO Auto-generated method stub
		
		List<SearchEngineDTO> listSearchEngine=new ArrayList<SearchEngineDTO>();
		listSearchEngine=questionDao.listSearchEngine();
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchEngine;
	}
	@Transactional
	public List<SearchKeywordDTO> listKeyword(int quesid) {
		// TODO Auto-generated method stub
		
		List<SearchKeywordDTO> listSearchKeyword=new ArrayList<SearchKeywordDTO>();
		listSearchKeyword=questionDao.listKeyword(quesid);
		//List<SearchEngine> searchEngines=new ArrayList<SearchEngine>();
		return listSearchKeyword;
	}
}
