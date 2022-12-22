package com.moviereview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.model.Review;
import com.moviereview.service.ReviewService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ReviewController {
	@Autowired
	private ReviewService rvwservice;
	
	//get data from sql
	@GetMapping("/reviews")
	public List<Review> getReview(){
		return this.rvwservice.getReviewData();
	}
	
	//add data into s
	@PostMapping(value="/addreview")
	public void addReview(@RequestBody Review rvw) {
		rvwservice.addReview(rvw);
		
	}
	
	//delete data
	@RequestMapping(method=RequestMethod.DELETE,value="/review/{rvwid}")
	public void deleteUser(@PathVariable int rvwid)
	{
		rvwservice.deleteReview(rvwid);
	}
	//get by id

		@RequestMapping(value = "/getreview/{rvwid}", method = RequestMethod.GET)
		public List<Review> getMovieData(@PathVariable("rvwid") Integer rvwid) {
			return rvwservice.getReviewData(rvwid);
		}
}

//package com.moviereview.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.moviereview.model.Review;
//import com.moviereview.serviceimpl.ReviewServiceImpl;
//
//
//@RestController
//@CrossOrigin(allowedHeaders = "*", origins = "*")
//public class ReviewController {
//
//	@Autowired
//	private ReviewServiceImpl reviewServiceImpl;
//
//	@PostMapping("/addreview")
//	public Review addReview(@RequestBody Review review) {
//		return reviewServiceImpl.addReview(review);
//	}
//	
//	@GetMapping("/getReviews")
//	public List<Review> getReviews(){
//		return reviewServiceImpl.getReviews();		
//	}
//	
//	@DeleteMapping("/deleteReview")
//	public void deleteReview(@RequestParam Integer r_no) {
//		reviewServiceImpl.deleteReview(r_no);
//	}
//	
//	@PutMapping("/updateReviewss")
//	public Review updateReview(@RequestBody Review review) {
//		return  reviewServiceImpl.updateReview(review);
//	}
//}
