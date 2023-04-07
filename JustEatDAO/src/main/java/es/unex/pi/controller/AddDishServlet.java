package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		// TODO Añadir plato a la Base de Datos.
		
		// Por ahora se vuelve a la página del restaurante concreto.
		response.sendRedirect (request.getContextPath () + "/UpdateDishesServlet.do?id=" + this.restaurant);
	}
}
