package com.moviereview.service;

import java.util.List;

import com.moviereview.model.Comment;

public interface CommentService {
	//get the data from sql
		public List<Comment> getCommentData();
		//get by id
		public List<Comment> getCommentData(Integer rvwid);
	//add
		public void addComment(Comment cmt);
}
