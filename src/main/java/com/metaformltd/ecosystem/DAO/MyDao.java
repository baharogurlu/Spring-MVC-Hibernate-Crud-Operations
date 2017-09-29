package com.metaformltd.ecosystem.DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import com.metaformltd.ecosystem.model.KimlikModel;

public interface MyDao {
	public void addPerson(KimlikModel person);

	public List<KimlikModel> getAllPerson();

	public void deletePerson(Integer personId);

	public KimlikModel getPerson(int personid);

	public KimlikModel updatePerson(KimlikModel person);
}
