package com.moviereview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.model.Approval;
import com.moviereview.service.ApprovalService;

@RestController
public class ApprovalController {

	@Autowired
	private ApprovalService aprlservice;
	
	//get data from sql
	@GetMapping("/approvals")
	public List<Approval> getApproval(){
		return this.aprlservice.getApprovalData();
	}
	
	@PutMapping(value="/updatestatus")
	public void updateApproval(@RequestBody Approval aprl)
	{
		aprlservice.updateApproval(aprl);
	}
}
