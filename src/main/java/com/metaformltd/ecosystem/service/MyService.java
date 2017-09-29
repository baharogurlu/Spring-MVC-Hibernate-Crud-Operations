package com.metaformltd.ecosystem.service;

import java.util.List;

import com.metaformltd.ecosystem.model.KimlikModel;

public interface MyService {
	
	public void addPerson(KimlikModel person);

	public List<KimlikModel> getAllPerson();

	public void deletePerson(Integer personId);

	public KimlikModel getPerson(int personid);

	public KimlikModel updatePerson(KimlikModel person);
}
