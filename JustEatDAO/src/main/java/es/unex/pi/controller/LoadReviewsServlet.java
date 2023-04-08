package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import es.unex.pi.model.Restaurant;
import es.unex.pi.model.Restaurant_User;
import es.unex.pi.model.User;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.Restaurant_UserDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCRestaurant_UserDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;

/**
 * Servlet implementation class LoadReviewsServlet
 */
public class LoadReviewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadReviewsServlet() {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext ().getAttribute ("dbConn");
		RestaurantDAO restaurantDAO = new JDBCRestaurantDAOImpl ();
		Restaurant_UserDAO restaurantUserDAO = new JDBCRestaurant_UserDAOImpl ();
		UserDAO userDAO = new JDBCUserDAOImpl ();
		
		User currentUser = (User) request.getSession ().getAttribute ("user");
		request.setAttribute ("currentUser", currentUser);
		
		restaurantDAO.setConnection (conn);
		long resID = Long.parseLong (request.getParameter ("id"));
		Restaurant currentRestaurant = restaurantDAO.get (resID);
		request.setAttribute ("restaurant", currentRestaurant);
		
		restaurantUserDAO.setConnection (conn);
		ArrayList <Restaurant_User> restaurantUserList = restaurantUserDAO.getAllByRestaurant (resID);
		request.setAttribute ("reviewList", restaurantUserList);
		
		userDAO.setConnection (conn);
		HashMap <Long, User> map = new HashMap <Long, User> ();
		for (Restaurant_User ru: restaurantUserList) {
			map.put (ru.getIdu (), userDAO.get (ru.getIdu ()));
			request.setAttribute ("userReview", map.get (ru.getIdu ()));
		}
		
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/LoadReviews.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO Coger con el getParameter el ID del restaurante y el ID del usuario es que el está en sesión*/
		
		//Devolver a la página de reviews para ver que se ha añadido.
		response.sendRedirect (request.getContextPath () + "/LoadReviewsServlet.do?id=" + request.getParameter ("id"));
	}
}
