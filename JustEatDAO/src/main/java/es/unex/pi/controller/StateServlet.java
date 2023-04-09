package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.model.Restaurant;

import es.unex.pi.util.RestaurantComparator;

/**
 * Servlet implementation class StateServlet
 */
public class StateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext ().getAttribute("dbConn"); //conectar con bd
		RestaurantDAO restBD = new JDBCRestaurantDAOImpl (); //objeto tipo Hosting con implementacion 
		
		restBD.setConnection (conn);//establecer conexion con la BD
		List <Restaurant> restaurantListBD = restBD.getAll ();
		List <Restaurant> restaurantList = null;
		String searchType = request.getParameter ("state-value");
		if(searchType.equals("all-restaurants")) { //igual al value
			request.setAttribute ("allrestaurants", "checked");
			request.setAttribute ("restaurantList", restaurantListBD);
		}
		restaurantList = new ArrayList <Restaurant> ();
		if (searchType.equals ("take-orders")) { //igual al value
			for(Restaurant restIter : restaurantListBD ) {
				if(restIter.getAvailable () == 1) {
					restaurantList.add (restIter);
				}
			}
			request.setAttribute("takeorders", "checked");
			request.setAttribute("restaurantList", restaurantList);
		}
		if(searchType.equals("no-take-orders")) {
			for (Restaurant restIter : restaurantListBD ) {
				if(restIter.getAvailable () ==0) {
					restaurantList.add (restIter);
				}
			}
			request.setAttribute("notakeorders", "checked");
			request.setAttribute("restaurantList", restaurantList);
		}
		
		if (searchType.equals ("reviews")) {
			Comparator <Restaurant> resComparator = new RestaurantComparator ();
			restaurantList = restBD.getAll ();
			Collections.sort (restaurantList, resComparator);
		}
		request.setAttribute ("reviews", "checked");
		request.setAttribute ("restaurantList", restaurantList);
		
		//Recarga la página para ver los resultados.
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/Search.jsp");
		view.forward (request, response);
	}

}
