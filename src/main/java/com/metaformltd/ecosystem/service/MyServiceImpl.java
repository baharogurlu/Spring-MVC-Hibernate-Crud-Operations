package com.metaformltd.ecosystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metaformltd.ecosystem.DAO.MyDao;
import com.metaformltd.ecosystem.model.KimlikModel;


@Service
@Transactional
public class MyServiceImpl implements MyService {

	
	@Autowired
	private MyDao dao;
	public void setPersonDAO(MyDao personDao) {
		this.dao = personDao;
	}

	@Override
	public void addPerson(KimlikModel person) {
		dao.addPerson(person);
	}

	@Override
	public List<KimlikModel> getAllPerson() {
		
		return dao.getAllPerson();
	}

	@Override
	public void deletePerson(Integer personId) {
		dao.deletePerson(personId);
		
	}

	@Override
	public KimlikModel getPerson(int personid) {
		return dao.getPerson(personid);
	}

	@Override
	public KimlikModel updatePerson(KimlikModel person) {
		return dao.updatePerson(person);
	}

}
