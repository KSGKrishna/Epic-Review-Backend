package com.moviereview.service;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.moviereview.model.Review;


@Repository
public interface ReviewService {

	public List <Review> getReviewData();
	//get by id
	public List<Review> getReviewData(Integer rvwid);
	//add data to sql
	public void addReview(Review rvw);
	//delete the data
	//public void deleteReview(String reviews);
	//update the data
	public void deleteReview(int rvwid);
	
}

//package com.moviereview.service;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.moviereview.model.Review;
//
//@Repository
//public interface ReviewService extends CrudRepository<Review, Integer> {
//
//}
