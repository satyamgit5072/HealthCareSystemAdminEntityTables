package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.DiagnosticCenter;
import com.healthcare.dto.Test;
import com.healthcare.service.HealthCareAdminService;

@RestController
public class HealthCareAdminController 
{
	@Autowired
	HealthCareAdminService adminService;

	@PostMapping(value="HealthCareSystem/add-center", consumes = {"application/json"})
	public String addStudent(@RequestBody DiagnosticCenter center)
	{
		return adminService.addCenter(center);
	}
	
	@PostMapping(value="HealthCareSystem/center/add-test/{centerName}", consumes = {"application/json"})
	public String addTest(@PathVariable String centerName,@RequestBody Test test)
	{
		DiagnosticCenter diagnosticCenter =adminService.findByCenterName(centerName);
		test.setCenter(diagnosticCenter);
		return adminService.addTest(test);
	} 
	
	@DeleteMapping(value="HealthCareSystem/remove-center/{centerName}")
	public boolean deleteCenter(@PathVariable String centerName)
	{
		DiagnosticCenter diagnosticCenter =adminService.findByCenterName(centerName);
		
		return adminService.removeCenter(diagnosticCenter);
	}
	

	@DeleteMapping(value="HealthCareSystem/remove-test/{centerName}/{testName}")
	public boolean deleteTest(@PathVariable String centerName,@PathVariable String testName)
	{
		DiagnosticCenter diagnosticCenter =adminService.findByCenterName(centerName);
		Test test = adminService.findByTestName(diagnosticCenter,testName);
		return adminService.removeTest(test);
	}
	
}