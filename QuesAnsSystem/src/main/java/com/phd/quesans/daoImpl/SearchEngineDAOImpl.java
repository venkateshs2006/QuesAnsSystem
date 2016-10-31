package com.phd.quesans.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phd.quesans.dao.SearchEngineDAO;
import com.phd.quesans.dto.SearchEngineDTO;
@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SearchEngineDTO getSearchEngine(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(SearchEngineDTO.class);
		criteria.add(Restrictions.idEq(new Integer(id)));
		return (SearchEngineDTO) criteria.list().get(0);
	}

	@Override
	public List<SearchEngineDTO> getSearchEngineList() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createCriteria(SearchEngineDTO.class).list();
	}

	@Override
	public int addSearchEngine(SearchEngineDTO searchEngine) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(searchEngine);
			System.out.println("Record Added");
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int deleteSearchEngine(SearchEngineDTO searchEngine) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(searchEngine);
			System.out.println("Record Deleted");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
