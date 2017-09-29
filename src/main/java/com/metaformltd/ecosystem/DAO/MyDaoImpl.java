package com.metaformltd.ecosystem.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metaformltd.ecosystem.model.KimlikModel;

@Repository
@Transactional
public class MyDaoImpl implements MyDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
		}

		return sessionFactory;
	}

	@Override
	public void addPerson(KimlikModel person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
		
	}

	@Override
	public List<KimlikModel> getAllPerson() {
		Criteria criteria = (Criteria) getSessionFactory().getCurrentSession().createCriteria(KimlikModel.class);
		return criteria.list();
	}

	@Override
	public void deletePerson(Integer personId) {
		//Criteria criteria = (Criteria) getSessionFactory().getCurrentSession().load(KimlikModel.class, personId);
		KimlikModel person = (KimlikModel) sessionFactory.getCurrentSession().load(
				KimlikModel.class, personId);
		if (person != null) {
			this.sessionFactory.getCurrentSession().delete(person);
		}
		
	}

	@Override
	public KimlikModel getPerson(int personid) {
		return (KimlikModel) sessionFactory.getCurrentSession().get(
				KimlikModel.class, personid);
	}

	@Override
	public KimlikModel updatePerson(KimlikModel person) {
		sessionFactory.getCurrentSession().update(person);
		return person;
	}
	
}
