package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
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
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCRestaurant_CategoryDAOImpl;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.Restaurant_CategoryDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.Restaurant_Category;
import es.unex.pi.model.User;

/**
 * Servlet implementation class AddDishServlet
 */
public class AddDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long restaurant = -1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDishServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.restaurant = Long.parseLong (request.getParameter ("id"));
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/AddDish.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		DishDAO dishBD = new JDBCDishDAOImpl(); // base de datos
		dishBD.setConnection(conn);
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		Dish dish = new Dish();
		dish.setName(name);
		dish.setPrice(price);
		dish.setDescription(description);
		HttpSession sesion = request.getSession();
		dish.setIdr(restaurant);
		dishBD.add(dish);
		
		response.sendRedirect(request.getContextPath() + "/UpdateDishesServlet.do?id=" + restaurant);
		
	}

}

