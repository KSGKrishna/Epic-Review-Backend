package com.moviereview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rvwid;
	private String comments;
	public int getRvwid() {
		return rvwid;
	}
	public void setRvwid(int rvwid) {
		this.rvwid = rvwid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int rvwid, String comments) {
		super();
		this.rvwid = rvwid;
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Comment [rvwid=" + rvwid + ", comments=" + comments + "]";
	}
}
