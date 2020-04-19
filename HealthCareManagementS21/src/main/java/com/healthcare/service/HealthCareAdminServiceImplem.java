package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.HealthCareAdminDAO;
import com.healthcare.dto.DiagnosticCenter;
import com.healthcare.dto.Test;

@Service
public class HealthCareAdminServiceImplem implements HealthCareAdminService 
{
	@Autowired
	HealthCareAdminDAO adminDAO;

	@Override
	public String addCenter(DiagnosticCenter diagnosticCenter) 
	{
		return adminDAO.addCenter(diagnosticCenter);
	}

	@Override
	public boolean removeCenter(DiagnosticCenter diagnosticCenter) 
	{
		return adminDAO.removeCenter(diagnosticCenter);
	}

	@Override
	public String addTest(Test test) 
	{
		return adminDAO.addTest(test);
	}

	@Override
	public boolean removeTest(Test test) 
	{
		return adminDAO.removeTest(test);
	}

	@Override
	public DiagnosticCenter findByCenterName(String centerName) 
	{
		return adminDAO.findByCenterName(centerName);
	}

	@Override
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName) 
	{
		return adminDAO.findByTestName(diagnosticCenter, testName);
	}

}
