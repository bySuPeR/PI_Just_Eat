package es.unex.pi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCOrderDAOImpl;
import es.unex.pi.dao.JDBCOrder_DishDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCRestaurant_CategoryDAOImpl;
import es.unex.pi.dao.OrderDAO;
import es.unex.pi.dao.Order_DishDAO;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.Restaurant_CategoryDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Order;
import es.unex.pi.model.Order_Dish;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.Restaurant_Category;
import es.unex.pi.model.User;

/**
 * Servlet implementation class AddOrderServlet
 */
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Añadir el pedido a la Base de Datos*/
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		OrderDAO orderBD = new JDBCOrderDAOImpl(); // base de datos
		orderBD.setConnection(conn);
		Order newOrder = new Order();
		HttpSession sesion = request.getSession();
		User user = (User) sesion.getAttribute("user");
		int totalPrice=0;
		newOrder.setTotalPrice(totalPrice);
		newOrder.setIdu(user.getId());
		long idOrder = orderBD.add(newOrder);
	
		String[] idDished = request.getParameterValues("selectedDish");
		if (idDished != null) {
			DishDAO dishBD = new JDBCDishDAOImpl();
			dishBD.setConnection(conn);
			Dish dish = new Dish();
			Order_DishDAO orDishBD = new JDBCOrder_DishDAOImpl();
			orDishBD.setConnection(conn);
			Order_Dish newOrderDish = new Order_Dish();
			long idDish=-1;
			for(int i=0;i< idDished.length ;i++) {
				idDish = Long.parseLong(idDished[i]);
				System.out.println("idDish: " + idDish);
				dish = dishBD.get(idDish);
				newOrderDish.setIddi(idDish);
				newOrderDish.setIdo(idOrder);
				System.out.println("idOrder: " + idOrder);
				orDishBD.add(newOrderDish);
				totalPrice=totalPrice+ dish.getPrice(); 
				System.out.println("Total: " + totalPrice);
			}
			newOrder.setTotalPrice(totalPrice);
			System.out.println("Total introducido: " + totalPrice);
			newOrder.setId(idOrder);
			orderBD.update(newOrder);
		
			response.sendRedirect (request.getContextPath () + "/MyOrdersServlet.do");
		}
		else {
			String error = "No se ha escogido ningún plato para este pedido";
			request.setAttribute("error", error);
			doGet(request, response);
		}
		
	}
}
