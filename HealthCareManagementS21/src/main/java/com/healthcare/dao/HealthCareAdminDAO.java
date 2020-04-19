package com.healthcare.dao;

import com.healthcare.dto.Test;
import com.healthcare.dto.DiagnosticCenter;

public interface HealthCareAdminDAO 
{
    public String addCenter(DiagnosticCenter diagnosticCenter);
	
	public boolean removeCenter(DiagnosticCenter diagnosticCenter);
	
	public String addTest(Test test);
	
	public boolean removeTest(Test test);
	
	public DiagnosticCenter findByCenterName(String centerName);
	
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName);


}
