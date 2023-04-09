package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;

import es.unex.pi.model.User;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.Restaurant_UserDAO;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCRestaurant_UserDAOImpl;

/**
 * Servlet implementation class UpdateReviewServlet
 */
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext ().getAttribute ("dbConn");
		RestaurantDAO restaurantDAO = new JDBCRestaurantDAOImpl ();
		Restaurant_UserDAO restaurantUserDAO = new JDBCRestaurant_UserDAOImpl ();
		restaurantDAO.setConnection (conn);
		restaurantUserDAO.setConnection (conn);
		
		long currentRestaurantID = Long.parseLong (request.getParameter ("id"));
		request.setAttribute ("restaurant", restaurantDAO.get (currentRestaurantID));
		User currentUser = (User) request.getSession ().getAttribute ("user");
		
		request.setAttribute ("comment", restaurantUserDAO.get (currentRestaurantID, currentUser.getId ()));
		
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/UpdateReview.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Actualiza la review. En la URL está el ID del restaurante al que pertenece la review
		 * y el usuario que la hace es el que tiene la sesión.
		 */
		
		//Tras actualizar, vuelve a cargar las reviews del restaurante.
		response.sendRedirect (request.getContextPath () + "/LoadReviewsServlet.do?id=" + request.getParameter ("id"));
	}
}
