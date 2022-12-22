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
import com.moviereview.model.Comment;
import com.moviereview.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	static List<Comment> commentlist=new ArrayList<Comment>();
	 
	Connection connection;
	
	public CommentServiceImpl() throws SQLException 
	{
		connection = DBUtil.getConnection();
	}
	@Override
	public List<Comment> getCommentData() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM epicreviews.comments;");
			ResultSet rs = stmt.executeQuery();	
			while(rs.next()) {
				Comment cmt=new Comment();
				cmt.setRvwid(rs.getInt(1));			
				cmt.setComments(rs.getString(2));
			
				commentlist.add(cmt);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return commentlist;
	}

	@Override
	public List<Comment> getCommentData(Integer rvwid) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM COMMENTS WHERE rvwid='"+rvwid+"'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Comment cmt=new Comment();
				cmt.setRvwid(rs.getInt(1));			
				cmt.setComments(rs.getString(2));
			
				commentlist.add(cmt);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return commentlist;
	}

	@Override
	public void addComment(Comment cmt) {
		int rvwid=cmt.getRvwid();
		String comments=cmt.getComments();		
		String insertQuery="INSERT INTO comments VALUES('"+rvwid+"','"+comments+"');";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Comment Added");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
