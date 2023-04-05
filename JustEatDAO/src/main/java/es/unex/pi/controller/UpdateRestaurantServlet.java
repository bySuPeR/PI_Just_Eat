package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import es.unex.pi.model.Restaurant;
import es.unex.pi.model.Category;
import es.unex.pi.model.Restaurant_Category;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.Restaurant_CategoryDAO;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCRestaurant_CategoryDAOImpl;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Servlet implementation class UpdateRestaurantServlet
 */
public class UpdateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRestaurantServlet () {
        super ();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext ().getAttribute ("dbConn");
		RestaurantDAO restaurantDAO = new JDBCRestaurantDAOImpl ();
		Restaurant_CategoryDAO resCatDAO = new JDBCRestaurant_CategoryDAOImpl ();
		CategoryDAO categoryDAO = new JDBCCategoryDAOImpl ();
		
		restaurantDAO.setConnection (conn);
		Restaurant currentRestaurant = restaurantDAO.get (Long.parseLong (request.getParameter ("id")));
		request.setAttribute ("restaurant", currentRestaurant);
		
		if (currentRestaurant.getBikeFriendly () == 1) {
			request.setAttribute ("yesbikefriendly", "checked");
		}
		else if (currentRestaurant.getBikeFriendly () == 0) {
			request.setAttribute ("nobikefriendly", "checked");
		}
		
		resCatDAO.setConnection (conn);
		ArrayList <Restaurant_Category> resCatList = resCatDAO.getAllByRestaurant (currentRestaurant.getId ());
		
		categoryDAO.setConnection (conn);
		ArrayList <Category> categoryList = categoryDAO.getAll ();
		request.setAttribute ("categoryList", categoryList);
		String catName = "";
		for (Restaurant_Category res_cat: resCatList) {
			catName = categoryDAO.get (res_cat.getIdct ()).getName ();
			System.out.println (catName);
			request.setAttribute (catName, "checked");
		}
		
		RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/UpdateRestaurant.jsp");
		view.forward (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO Actualizar los valores en la Base de Datos*/
	}
}
