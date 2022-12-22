package com.moviereview.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereview.DBUtil.DBUtil;
import com.moviereview.model.Approval;
import com.moviereview.service.ApprovalService;
@Service
public class ApprovalServiceImpl implements ApprovalService{

	@Autowired
	static List<Approval> Approvallist=new ArrayList<Approval>();
	 
	Connection connection;
	
	public ApprovalServiceImpl() throws SQLException 
	{
		connection = DBUtil.getConnection();
	}
	@Override
	public List<Approval> getApprovalData() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM epicreviews.approval ");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Approval aprl=new Approval();
				aprl.setUserid(rs.getInt(1));			
				aprl.setMovies(rs.getString(2));
				aprl.setReview(rs.getString(3));
				aprl.setStatus(rs.getString(4));
				Approvallist.add(aprl);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		return Approvallist;	
	}

	@Override
	public void updateApproval(Approval aprl) {
		int userid=aprl.getUserid();
//		String movies=aprl.getMovies();
//		String review=aprl.getReview();
		String status=aprl.getStatus();
		
		
		String updateQuery="UPDATE approval SET status='"+status+"' WHERE userid='"+userid+"';";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("UPDATED SUCCESSFULLY");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
