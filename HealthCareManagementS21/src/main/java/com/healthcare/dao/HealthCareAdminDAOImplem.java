package com.healthcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.dto.DiagnosticCenter;
import com.healthcare.dto.Test;

@Transactional
@Repository
public class HealthCareAdminDAOImplem implements HealthCareAdminDAO 
{
	@PersistenceContext
	EntityManager entityManager;
	
//	@Autowired
//	Test t1,t2;
	
	@Override
	public String addCenter(DiagnosticCenter diagnosticCenter)
	{
		Test t5 = new Test();
		t5.setCenter(diagnosticCenter);
		t5.setTestName("blood group");
		entityManager.persist(t5);
		Test t6 = new Test();
		t6.setCenter(diagnosticCenter);
		t6.setTestName("blood sugar");
		entityManager.persist(t6);
		Test t7 = new Test();
		t7.setCenter(diagnosticCenter);
		t7.setTestName("blood pressure");
		entityManager.persist(t7);
		
		
//		t1.setCenter(diagnosticCenter);
//		t1.setTestName("blood sugar");
//		entityManager.persist(t1);
//		t2.setCenter(diagnosticCenter);
//		t2.setTestName("blood pressure");
//		entityManager.persist(t2);
		
		entityManager.persist(diagnosticCenter);
		return "center added successfully";
	}

	@Override
	public boolean removeCenter(DiagnosticCenter diagnosticCenter)
	{
		entityManager.remove(diagnosticCenter);
		return true;
	}

	@Override
	public String addTest(Test test) 
	{
		entityManager.persist(test);
		return "test added sucessfully";
	}

	@Override
	public boolean removeTest(Test test)
	{
		entityManager.remove(test);
		return true;
	}

	@Override
	public DiagnosticCenter findByCenterName(String centerName) 
	{
		String queryStr = "select center from DiagnosticCenter center where center.centerName=:centerName";
		TypedQuery<DiagnosticCenter> query = entityManager.createQuery(queryStr,DiagnosticCenter.class);
		DiagnosticCenter diagnosticCenter = query.setParameter("centerName", centerName).getSingleResult();
		return diagnosticCenter;
	}
	
	@Override
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName)
	{
		String queryStr = "select test from Test test where test.diagnosticCenter=:diagnosticCenter and test.testName=:testName";
		TypedQuery<Test> query = entityManager.createQuery(queryStr,Test.class);
		Test test = query.setParameter("diagnosticCenter",diagnosticCenter).setParameter("testName",testName).getSingleResult();
		return test;
	}

}
