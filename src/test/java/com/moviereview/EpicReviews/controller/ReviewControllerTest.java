package com.moviereview.EpicReviews.controller;


import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviereview.model.Review;
import com.moviereview.service.ReviewService;
import com.moviereview.serviceimpl.ReviewServiceImpl;


@RunWith(SpringRunner.class)

@SpringBootTest 
class ReviewControllerTest {
	
	@Autowired 
  	private ReviewService reviewService;
	
	@MockBean 
  	private ReviewServiceImpl reviewServiceImpl;

	@Test
	public void getReviewTest() throws Exception {
		when(reviewServiceImpl.getReviewData()).thenReturn((List<Review>) Stream.of(new Review(1,"Avatar","Good","4","Mani")).collect(Collectors.toList()));
		assertEquals(1,reviewServiceImpl.getReviewData().size());
		
	}
	
	@Test
	public void addReviewTest() throws Exception {
		Review review = new Review(1,"Avatar","Good","4","Mani");
		doNothing().when(reviewService).addReview(review);
//		assertEquals(review, reviewService.addReview(review));
		review.addReview(1,"Avatar","Good","4","Mani");
		//verify(review, times(1)).addReview(1,"Avatar","Good","4","Mani");
	}

}
