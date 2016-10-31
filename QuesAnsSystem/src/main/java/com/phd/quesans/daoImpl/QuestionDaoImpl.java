package com.phd.quesans.daoImpl;

import java.util.List;





import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phd.quesans.dao.QuestionDao;
import com.phd.quesans.dto.QuestionDTO;
import com.phd.quesans.dto.SearchEngineDTO;
import com.phd.quesans.dto.SearchKeywordDTO;
import com.phd.quesans.model.Question;
@Repository
public class QuestionDaoImpl implements QuestionDao{
	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public List<String> listQuestion(String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria = session.createCriteria(QuestionDTO.class);
		criteria.add(Expression.ilike("question", "%"+term+"%"));

		criteria.setProjection(Projections.property("question"));

		criteria.addOrder(Order.asc("question"));

		return criteria.list();		
	}
	@Override
	public QuestionDTO getQuestionPojo(String question) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria = session.createCriteria(QuestionDTO.class);
		criteria.add(Expression.ilike("question", "%"+question+"%"));
		return (QuestionDTO) criteria.list().get(0); // Need to check null condition. 

	}
	@Override
	public List<SearchEngineDTO> listSearchEngine() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();		 
		return session.createCriteria(SearchEngineDTO.class).list();		
	}
	@Override
	public List<SearchKeywordDTO> listKeyword(int quesid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria = session.createCriteria(SearchKeywordDTO.class);
		criteria.add(Expression.eq("quesid", quesid));
		return criteria.list();	
	}
	
}
