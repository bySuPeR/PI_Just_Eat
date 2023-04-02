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

import es.unex.pi.dao.OrderDishesDAO;
import es.unex.pi.dao.JDBCOrderDishesDAOImpl;
import es.unex.pi.model.Order_Dish;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestOrderDishesDAO {

	static DBConn dbConn;
	static OrderDishesDAO OrderDishesDAO;
	static Connection conn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbConn = new DBConn();
		conn = dbConn.create();
	    OrderDishesDAO = new JDBCOrderDishesDAOImpl();
		OrderDishesDAO.setConnection(conn);
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
		
		List<Order_Dish> OrderDishesList = OrderDishesDAO.getAll();
		
		Order_Dish OrderDishes = OrderDishesDAO.get(0,0);
		
		assertEquals(OrderDishes.getIdo(),0);
		assertEquals(OrderDishes.getIddi(),0);
		
		assertEquals(OrderDishesList.get(0).getIdo(),OrderDishes.getIdo());			
			
	}
	
	@Test
	public void test2BaseDataByDish() {
		
		List<Order_Dish> OrderDishesList = OrderDishesDAO.getAllByDish(2);
		for(Order_Dish OrderDishes: OrderDishesList)			
			assertEquals(OrderDishes.getIddi(),2);			
	}
	
	@Test
	public void test3BaseDataByOrder() {
		
		List<Order_Dish> OrderDishesList = OrderDishesDAO.getAllByOrder(1);
		for(Order_Dish OrderDishes: OrderDishesList)			
			assertEquals(OrderDishes.getIdo(),1);			
	}
	
	@Test
	public void test4Add(){
		Order_Dish orderDishes01 = new Order_Dish();
		orderDishes01.setIdo(2);
		orderDishes01.setIddi(1);
		OrderDishesDAO.add(orderDishes01);
		
		Order_Dish orderDishes02 = OrderDishesDAO.get(2,1);
		
		assertEquals(2,orderDishes02.getIdo());
		assertEquals(1,orderDishes02.getIddi());
				
	}
	
	
	@Test
	public void test5Modify(){
		
		Order_Dish orderDishes01 = OrderDishesDAO.get(2,1);
		Order_Dish orderDishes02 = OrderDishesDAO.get(2,1);
		orderDishes02.setIddi(0);
		OrderDishesDAO.update(orderDishes01,orderDishes02);
		
		Order_Dish orderDishes03 = OrderDishesDAO.get(2,0);
		assertEquals(2,orderDishes03.getIdo());
		assertEquals(0,orderDishes03.getIddi());
	}
	
	@Test
	public void test6Delete(){
		 
		OrderDishesDAO.delete(2,0);
		List<Order_Dish> OrderDishesList = OrderDishesDAO.getAll();
		 
		 Order_Dish OrderDishes01 = new Order_Dish();
		 OrderDishes01.setIdo(2);
		 OrderDishes01.setIddi(0);
		 		 
		for(Order_Dish OrderDishes: OrderDishesList) {
				assertNotEquals(OrderDishes,OrderDishes01);
		}
		 
	}

}
