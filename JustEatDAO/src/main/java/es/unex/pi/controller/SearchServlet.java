package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conn = (Connection) getServletContext ().getAttribute ("dbConn");
    	RestaurantDAO restaurantDAO = new JDBCRestaurantDAOImpl ();
    	restaurantDAO.setConnection (conn);
    	request.setAttribute ("restaurantList", restaurantDAO.getAll ());
    	RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/Search.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * TODO Buscar restaurante por localidad, nombre o dirección donde se encuentra.
		 * Existen un método del DAO que devuelve un ArrayList con dicha funcionalidad.
		 */
	}
}
