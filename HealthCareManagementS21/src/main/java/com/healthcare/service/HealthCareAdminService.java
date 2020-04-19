package com.healthcare.service;

import com.healthcare.dto.DiagnosticCenter;
import com.healthcare.dto.Test;

public interface HealthCareAdminService 
{
	    public String addCenter(DiagnosticCenter diagnosticCenter);
		
		public boolean removeCenter(DiagnosticCenter diagnosticCenter);
		
		public String addTest(Test test);
		
		public boolean removeTest(Test test);
		
		public DiagnosticCenter findByCenterName(String centerName);
		
		public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName);

}
