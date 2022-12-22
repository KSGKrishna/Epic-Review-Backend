package com.moviereview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.model.Comment;
import com.moviereview.service.CommentService;
@RestController
public class CommentController {
@Autowired
	private CommentService cmtservice;
// all comments
	@GetMapping("/allcomments")
	public List<Comment> getComment(){
		return this.cmtservice.getCommentData();
	}
	//get by id

	@RequestMapping(value = "/getcomment/{rvwid}", method = RequestMethod.GET)
	public List<Comment> getMovieData(@PathVariable("rvwid") Integer rvwid) {
		return cmtservice.getCommentData(rvwid);
	}
	
	//add data into s
	@PostMapping(value="/addcomment")
	public void addComment(@RequestBody Comment cmt) {
		cmtservice.addComment(cmt);
		
	}
}
