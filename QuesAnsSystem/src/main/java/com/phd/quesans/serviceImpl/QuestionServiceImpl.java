package com.phd.quesans.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phd.quesans.dao.AdminQuestionDAO;
import com.phd.quesans.dao.SearchEngineDAO;
import com.phd.quesans.dto.QuestionDTO;
import com.phd.quesans.dto.SearchEngineDTO;
import com.phd.quesans.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	 private AdminQuestionDAO adminQuestionDAO;

	@Override
	@Transactional
	public QuestionDTO getQuestion(int id) {
		// TODO Auto-generated method stub
		return adminQuestionDAO.getQuestion(id);
	}
	

	@Override
	@Transactional
	public List<QuestionDTO> getQuestionList() {
		// TODO Auto-generated method stub
		return adminQuestionDAO.getQuestionList();
	}

	@Override
	@Transactional
	public int addQuestion(QuestionDTO question) {
		// TODO Auto-generated method stub
		return adminQuestionDAO.addQuestion(question);
	}

	@Override
	@Transactional
	public int deleteQuestion(QuestionDTO question) {
		// TODO Auto-generated method stub
		return adminQuestionDAO.addQuestion(question);
	}



}
