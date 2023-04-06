package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import es.unex.pi.model.Restaurant;
import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.RestaurantDAO;

/**
 * Servlet implementation class UpdateDishesServlet
 */
public class UpdateDishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long restaurant = -1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDishesServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext ().getAttribute ("dbConn");
		RestaurantDAO restaurantDAO = new JDBCRestaurantDAOImpl ();
		DishDAO dishDAO = new JDBCDishDAOImpl ();
		
		restaurantDAO.setConnection (conn);
		this.restaurant = Long.parseLong (request.getParameter ("id"));
		Restaurant currentRestaurant = restaurantDAO.get (this.restaurant);
		
		dishDAO.setConnection (conn);
		request.setAttribute ("dishList", dishDAO.getAllByRestaurant (currentRestaurant.getId ()));
		
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/UpdateDishes.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO Actualiza la información de los platos en la Base de Datos*/
		
		//Por ahora, solo devuelve a la página de edición del restaurante.
		response.sendRedirect (request.getContextPath () + "/UpdateRestaurantServlet.do?id=" + this.restaurant);
	}
}
