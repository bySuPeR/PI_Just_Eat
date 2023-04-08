package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCDishDAOImpl;

/**
 * Servlet implementation class MakeOrderServlet
 */
public class MakeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeOrderServlet () {
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
		dishDAO.setConnection (conn);
		
		request.setAttribute ("dishList", dishDAO.getAllByRestaurant (Long.parseLong (request.getParameter ("id"))));
		RequestDispatcher vista = request.getRequestDispatcher("/WEB-INF/NewOrder.jsp");
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Añadir el pedido a la Base de Datos*/
		
		//Devuelve a la pantalla de los pedidos para ver que se ha añadido.
		response.sendRedirect (request.getContextPath () + "/MyOrdersServlet.do");
	}
}
