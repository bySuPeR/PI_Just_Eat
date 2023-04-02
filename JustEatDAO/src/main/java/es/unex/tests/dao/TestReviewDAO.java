package es.unex.tests.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.unex.pi.dao.ReviewsDAO;
import es.unex.pi.dao.JDBCReviewsDAOImpl;
import es.unex.pi.model.Restaurant_User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestReviewDAO {

	static DBConn dbConn;
	static ReviewsDAO reviewsDAO;
	static Connection conn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbConn = new DBConn();
		conn = dbConn.create();
	    reviewsDAO = new JDBCReviewsDAOImpl();
		reviewsDAO.setConnection(conn);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		dbConn.destroy(conn);
	}

	@Before
	public void setUpBeforeMethod() throws Exception {
	
	}

	@Test
	public void test1BaseData() {
		
		List<Restaurant_User> reviewsList = reviewsDAO.getAll();
		
		Restaurant_User review = reviewsDAO.get(0,2);
		
		assertEquals(review.getIdr(),0);
		assertEquals(review.getIdu(),2);
		
		assertEquals(reviewsList.get(0).getIdr(),review.getIdr());			
			
	}
	
	@Test
	public void test2BaseDataByUser() {
		
		List<Restaurant_User> reviewsList = reviewsDAO.getAllByUser(4);
		for(Restaurant_User reviews: reviewsList)			
			assertEquals(reviews.getIdu(),4);			
	}
	
	@Test
	public void test3BaseDataByRestaurant() {
		
		List<Restaurant_User> reviewsList = reviewsDAO.getAllByRestaurant(0);
		for(Restaurant_User reviews: reviewsList)			
			assertEquals(reviews.getIdr(),0);			
	}
	
	@Test
	public void test4Add(){
		Restaurant_User review01 = new Restaurant_User();
		review01.setIdr(4);
		review01.setIdu(1);
		review01.setReview("NewReviewComment");
		review01.setGrade(5);
		
		reviewsDAO.add(review01);
		
		Restaurant_User review02 = reviewsDAO.get(4,1);
		
		assertEquals(4,review02.getIdr());
		assertEquals(1,review02.getIdu());
				
	}
	
	
	@Test
	public void test5Modify(){
		
		Restaurant_User review01 = reviewsDAO.get(3,0);
		String oldReview = review01.getReview();
		int oldGrade = review01.getGrade();
		
		review01.setReview("NewReview");
		review01.setGrade(5);
		reviewsDAO.update(review01);
		
		Restaurant_User review02 = reviewsDAO.get(3,0);
		assertEquals("NewReview",review02.getReview());
		assertEquals(5,review02.getGrade());

		review01.setReview(oldReview);
		review01.setGrade(oldGrade);		
		reviewsDAO.update(review01);

		review02 = reviewsDAO.get(3,0);
		assertEquals(oldReview,review02.getReview());
		assertEquals(oldGrade,review02.getGrade());

	
	}
	
	@Test
	public void test6Delete(){
		 
		reviewsDAO.delete(4,1);
		List<Restaurant_User> reviewsList = reviewsDAO.getAll();
		 
		 Restaurant_User reviews01 = new Restaurant_User();
		 reviews01.setIdr(3);
		 reviews01.setIdu(1);
		 		 
		for(Restaurant_User reviews: reviewsList) {
				assertNotEquals(reviews,reviews01);
		}
		 
	}

}
