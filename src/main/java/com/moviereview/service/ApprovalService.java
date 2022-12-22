package com.moviereview.service;

import java.util.List;

import com.moviereview.model.Approval;

public interface ApprovalService {
	public List<Approval> getApprovalData();
	
	public void updateApproval(Approval aprl);
}
