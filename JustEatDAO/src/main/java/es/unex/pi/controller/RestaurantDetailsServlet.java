package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;

import es.unex.pi.model.Restaurant;
import es.unex.pi.model.User;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;

/**
 * Servlet implementation class RestaurantDetailsServlet
 */
public class RestaurantDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantDetailsServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext ().getAttribute ("dbConn");
		RestaurantDAO restaurantDAO = new JDBCRestaurantDAOImpl ();
		restaurantDAO.setConnection (conn);
		
		Restaurant currentRestaurant = restaurantDAO.get (Long.parseLong (request.getParameter ("id")));
		request.setAttribute ("restaurant", currentRestaurant);
		User currentUser = (User) request.getSession ().getAttribute ("user");
		request.setAttribute ("currentUser", currentUser);
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/Res_details.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet (request, response);
	}
}
